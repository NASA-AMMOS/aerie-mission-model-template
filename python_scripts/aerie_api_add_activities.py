import json
import requests
from json_request_writer import shadow_activities

api_url = 'http://localhost:8080/v1/graphql' # https://aerie-dev.jpl.nasa.gov:8080/v1/graphql
query = '''mutation InsertActivities($activities: [activity_directive_insert_input!]!) {insert_activity_directive(objects: $activities) {returning {id name } } } '''

activities = shadow_activities

sc_id = "MMS"
shadow_type = "some shadow"
# duration is in microseconds

''' 
An example of the JSON k:v format 
activities = [
	{
	  "type": "InShadow",
	  "start_offset": "00:00:87.9",
	  "arguments": {
		 'scId' : sc_id, 'startTime' : '0', 'duration' : 93784000000, 'shadowType' : 'UMBRA'
				
	  },
	  "name": "InShadow",
	  "plan_id": plan_id
	}
]
'''
activities = shadow_activities

response = requests.post(
  url=api_url,
  json={ 
    'query': query,
     'variables': { "activities": activities },
  },
  verify=False
)

print("SENT:")
print(activities)

print("RESPONSE")
print(json.dumps(response.json(), indent=2))
