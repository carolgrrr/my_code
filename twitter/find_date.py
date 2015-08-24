from pymongo import MongoClient
import datetime, timedelta
import pytz

client = MongoClient()
db = client.twitter
col = db.tweets
print 'connected to mongodb'
cursor = col.find_one()
found_timestamp = cursor['date']
# timestamp = 4/1/15 00:00:00
query_start_date = (datetime.datetime.fromtimestamp(1427864400))
found_date = datetime.datetime.fromtimestamp(found_timestamp/1e3)
date_span = datetime.timedelta(hours=24)
query_end_date = (query_start_date+date_span)
print(found_date)
print(query_start_date)
print(query_end_date)

if(query_end_date > found_date and found_date > query_start_date):
	print ('within time window')
else:
	print('outside time window')

# set cursor equal to location query results
# iterate through cursor to filter for time
# if a time is within time window, add to new cursor?
# if a time is outside time window, move to next cursor item

