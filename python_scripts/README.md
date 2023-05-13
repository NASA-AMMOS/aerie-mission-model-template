# READ ME

In branch `proto-shadows`:
1. Build jar
2. Create new plan in Aerie UI with new jar and open UI with plan
3. Add shadow files to the same directory as the python files 
4. Update `json_request_writer.py` to include the plan ID from the Aerie UI.
5. Run `json_request_writer.py`
6. Run `aerie_api_add_activities.py`
7. You should see the UI get populated with activities
