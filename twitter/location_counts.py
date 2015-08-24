from pymongo import MongoClient, GEO2D
import datetime
import pytz

# wincom blue
# python version = 2.7.3
# mongodb version = 3.0.4

client = MongoClient()
db = client.twitter
col = db.tweets
print 'connected to mongodb'
db.col.create_index([("GeoJSON", GEO2D)])
# lower left: [-87.635452, 41.828759]
# upper right: [-87.632265, 41.830926]

ohare = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.939593, 41.949526], [-87.939593, 42.009503], [-87.87813, 42.009503], [-87.87813, 41.949526], [-87.939593, 41.949526]]]}}}})
midway = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.761758, 41.778120], [-87.761758, 41.792967], [-87.741888, 41.792967], [-87.741888, 41.778120], [-87.761758, 41.778120]]]}}}})
union_station = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.640343, 41.878744], [-87.640343,  41.879256], [-87.638594, 41.879256], [-87.638594, 41.878744], [-87.640343, 41.878744]]]}}}})
ogilvie = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.641168, 41.881883], [-87.641168,  41.883153], [-87.639848, 41.883153], [-87.638594, 41.881883], [-87.641168, 41.881883]]]}}}})

sox_park = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.635452, 41.828759], [-87.635452, 41.830926], [-87.632265, 41.830926], [-87.632265, 41.828759], [-87.635452, 41.828759]]]}}}})
united_center = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.675174, 41.880056], [-87.675174, 41.881302], [-87.673210, 41.881302], [-87.673210, 41.880056], [-87.675174, 41.880056]]]}}}})

the_bean = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.623465, 41.882405], [-87.623465, 41.882973], [-87.623089, 41.882973], [-87.623089, 41.882405], [-87.623465, 41.882405]]]}}}})
sears_tower = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.636580, 41.878129], [-87.636580, 41.879279], [-87.635346, 41.879279], [-87.635346, 41.878129], [-87.636580, 41.878129]]]}}}})

iit = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.629667, 41.831084], [-87.629667, 41.840197], [-87.623444, 41.840197], [-87.623444, 41.831084], [-87.629667, 41.831084]]]}}}})
art_institute = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.624142, 41.878318], [-87.624142, 41.880826], [-87.620934, 41.880826], [-87.620934, 41.878318], [-87.624142, 41.878318]]]}}}})
uic = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.659660, 41.874328], [-87.659660, 41.875271], [-87.657149, 41.875271], [-87.657149, 41.874328], [-87.659660, 41.874328]]]}}}})

chicago_theater = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.627849, 41.885144], [-87.627849, 41.885717], [-87.626309, 41.885717], [-87.626309, 41.885144], [-87.627849, 41.885144]]]}}}})
hob = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.629347, 41.888106], [-87.629347, 41.888372], [-87.628819, 41.888372], [-87.628819, 41.888106], [-87.629347, 41.888106]]]}}}})
metro = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.659074, 41.949700], [-87.659074, 41.949924], [-87.659074, 41.949924], [-87.658709, 41.949700], [-87.659074, 41.949700]]]}}}})

loop = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.638797, 41.867407], [-87.638797, 41.887057], [-87.588160, 41.887057], [-87.588160, 41.867407], [-87.638797, 41.867407]]]}}}})

north_side = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.940679, 41.882094], [-87.940679, 42.008335], [-87.588160, 42.008335], [-87.588160, 41.882094], [-87.940679, 41.882094]]]}}}})
south_side = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.940679, 41.715395], [-87.940679, 41.882094], [-87.588160, 41.882094], [-87.588160, 41.715395], [-87.940679, 41.715395]]]}}}})
chicago = col.find({'GeoJSON': {'$geoWithin': {'$geometry': {'type': 'Polygon', 'coordinates': [[[-87.940679, 41.715395], [-87.940679, 42.008335], [-87.588160, 42.008335], [-87.588160, 41.715395], [-87.940679, 41.715395]]]}}}})


print 'queried tweets from several locations'

sox_park_over_time = []

# timestamp = 4/1/15 00:00:00
query_start_date = (datetime.datetime.fromtimestamp(1427864400))
date_span = datetime.timedelta(hours=24)
query_end_date = (query_start_date+date_span)

for doc in sox_park:
	found_timestamp = doc['date']
	found_date = datetime.datetime.fromtimestamp(found_timestamp/1e3)
	if(query_end_date > found_date and found_date > query_start_date):
		print(doc)
		sox_park_over_time.append(doc)

for record in sox_park_over_time:
	print(record)
