
from bs4 import BeautifulSoup

import requests

def print_job_ids(url):
	r = requests.get(url)
	data = r.text
	soup = BeautifulSoup(data, 'html.parser')

	for item in soup.find_all(class_="searchitem PUBLIC"):
		print(item.get('id'))

def get_job_ids(url, id_set):
	r = requests.get(url)
	data = r.text
	soup = BeautifulSoup(data, 'html.parser')

	for item in soup.find_all(class_="searchitem PUBLIC"):
		id_set.add(item.get('id'))

	return id_set

def run_print_function(base_url):
	result_number = 11
	result_string = '11'
	url = base_url + result_string

	while(result_number < 1266):
		print("results: %d" % result_number)
		print_job_ids(url)
		result_number += 10
		result_string = str(result_number)
		url = base_url + result_string

	print('all results printed')


print('searching for volunteer jobs in Chicago')


#url = 'https://www.volunteermatch.org/'
# search for jobs in chicago
base_url = 'https://www.volunteermatch.org/search?l=Chicago%2C+IL%2C+USA'
result_number = 1
result_string = str(result_number)
url = base_url + result_string
print_job_ids(base_url)

base_url = 'https://www.volunteermatch.org/search/?aff=&includeOnGoing=true&r=20.0&l=Chicago%2C+IL%2C+USA&o=recency&s='
#run_print_function(base_url)

id_set = set()
#actual number for all results: 1/15/18
#while result_number < 1266:
while result_number < 25:
	full_url = base_url + result_string
	id_set = get_job_ids(full_url, id_set)
	result_number += 10
	result_string = str(result_number)

print("there are %d volunteer jobs in Chicago" % len(id_set))
opportunity_list = []

for opportunity in id_set:
	#print('\n\n NEW OPPORTUNITY \n\n')
	url = 'https://www.volunteermatch.org/search/' + opportunity + '.jsp'
	r = requests.get(url)
	data = r.text
	soup = BeautifulSoup(data, 'html.parser')
	title = str(soup.find(class_='opp_title_heading'))
	organization = str(soup.find(class_='opp_detail_org_name'))
	summary = str(soup.find(class_="opp_summary"))
	#summaries = soup.find_all(class_="opp_summary")
	#headings = soup.find_all(class_='uxp_heading')
	headings = soup.find_all(class_='opp_lower_container_section')

	#print(title)
	#print(organization)
	#print(summary)

	opportunity_string = ""
	opportunity_string += title
	opportunity_string += organization
	opportunity_string += summary
	
	for item in headings:
		item_string = str(item)
		#print(item)
		opportunity_string += item_string
		pass

	opportunity_list.append(opportunity_string)

	#span = soup.find("span", {"class":"displaytext"})  # span.string gives you the first bit
	#paras = [x.contents[0] for x in summaries.findAllNext("p")]  # this gives you the rest
	# use .contents[0] instead of .string to deal with last para that's not well formed

	#print ("%s\n\n%s" % (summaries.string, "\n\n".join(paras)))

	#paragraphs = summaries.find('p')
	# prints first paragraph in each summary
	#for para in summaries:
	#	print(para.get_text())

	#print(summaries[0].p)
	#print(summaries)
	# class_ = uxp_heading (Skills, Good Match For, Requirements & Commitments) - opp_lower_container_section
	# class_ = opp_title_heading
	# class_ = opp_detail_org_name
	# class_ = uxp_heading (Cause Areas, When, Where)

print(opportunity_list[0])




