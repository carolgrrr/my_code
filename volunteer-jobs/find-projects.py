
from bs4 import BeautifulSoup

import requests

def print_job_ids(url):
	r = requests.get(url)
	data = r.text
	soup = BeautifulSoup(data, 'html.parser')

	for item in soup.find_all(class_="searchitem PUBLIC"):
		print(item.get('id'))


print('searching for volunteer jobs in Chicago')


#url = 'https://www.volunteermatch.org/'
# search for jobs in chicago
base_url = 'https://www.volunteermatch.org/search?l=Chicago%2C+IL%2C+USA'
result_number = 1
result_string = str(result_number)
url = base_url + result_string
print_job_ids(base_url)

base_url = 'https://www.volunteermatch.org/search/?aff=&includeOnGoing=true&r=20.0&l=Chicago%2C+IL%2C+USA&o=recency&s='
result_string = '11'
url = base_url + result_string

while(result_number < 1266):
	print("results: %d" % result_number)
	print_job_ids(url)
	result_number += 10
	result_string = str(result_number)
	url = base_url + result_string


print('all results printed')

# prints job id numbers of all jobs in Chicago (no dupes when sorted by recency)
# save id numbers in a list
# go to job page for each id and get job details
# save details in csv

