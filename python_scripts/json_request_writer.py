import re
import json
import datetime
from datetime import timedelta

# Update these paths to your file
MMS_1 = "MMS1_SHADOWS_2023027_2023202.V00"
MMS_2 = "MMS2_SHADOWS_2023027_2023202.V00"
MMS_3 = "MMS3_SHADOWS_2023027_2023202.V00"
MMS_4 = "MMS4_SHADOWS_2023027_2023202.V00"

# Add plan id
plan_id = 21

# Add start time you want to delta off of 
plan_start = '2023-001/00:00:00'
date_format = '%Y-%j/%H:%M:%S'
plan_start_formatted = datetime.datetime.strptime(plan_start, date_format)


shadow_activities = []
shadow_file_names = [MMS_1, MMS_2, MMS_3, MMS_4]

for file_name in shadow_file_names:
	sc_id = re.findall("(MMS\d{1})",file_name)[0]

	if sc_id == "MMS2" or sc_id == "MMS3" or sc_id == "MMS4":
		continue

	with open(file_name) as f:
		for i in range(12):
			next(f)
		j = 0
		for line in f:
			start_time, stop_time = re.findall("\d{4}[-]\d{3}[/]\d{2}[:]\d{2}[:]\d{2}", line)
			activity_start_formatted = datetime.datetime.strptime(start_time, date_format)
			start_offset_seconds = timedelta.total_seconds(activity_start_formatted - plan_start_formatted)
			hours_offset = start_offset_seconds//3600
			start_offset_seconds -= hours_offset*3600
			minutes_offset = start_offset_seconds//60
			start_offset_seconds -= minutes_offset*60

			start_offset = '{}:{}:{}'.format(int(hours_offset), int(minutes_offset), start_offset_seconds)
			# duration is in microseconds in Aerie UI, in min in shadow file
			duration = re.findall("\d{1,}[.]\d{3}", line)[0]
			duration = float(duration) * 6e7
			duration = int(duration)

			if "Penumbra" in line:
				shadow_type = "PENUMBRA"
			else:
				shadow_type = "UMBRA"

			print(shadow_type)

			activity_data = { 
				'arguments': { 'scId' : sc_id, 'startTime' : start_time, 'duration' : duration, 'shadowType' : shadow_type},
				'plan_id': plan_id,
			    'name': 'InShadow',
			    'start_offset': start_offset,
			    'type': 'InShadow'
			}
			shadow_activities.append(activity_data)
		
