
from bs4 import BeautifulSoup

import requests
import pickle

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


def from_volunteer_match(input_url):

	print('searching for volunteer jobs in Chicago')


	#url = 'https://www.volunteermatch.org/'
	# search for jobs in chicago
	base_url = input_url
	result_number = 1
	result_string = str(result_number)
	url = base_url + result_string
	#print_job_ids(base_url)

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

	#for opp in opportunity_list:
	#	print(opp)
	pickle.dump( opportunity_list, open( "chicago-30-jobs.p", "wb" ) )
	print('opportunity_list pickled.')
	#print(opportunity_list[0])

def get_page_links(html):
	page_links = set()

	for item in html.find_all(class_='page-item'):
		for atag in item.find_all('a'):
			link = atag.get('href')
			link_string = str(link)
			if link_string.startswith('?page='):
				page_links.add(link_string)
	return page_links



def from_catch_a_fire(input_url):

	r = requests.get(input_url)
	data = r.text
	soup = BeautifulSoup(data, 'html.parser')

	opportunies = set()
	page_list = get_page_links(html)

	for item in soup.find_all('a'):
		link = item.get('href')
		link_string = str(link)
		if link_string.startswith('/volunteer/'):
			print(link_string)
			opportunies.add(link_string)
		#elif link_string.startswith('?/page='):
		#	print(link_string)
		#	page_list.append(link_string)
	print ('links found')

	#print(soup)


def from_la_works():
	url = 'https://www.laworks.com/opportunity-search'
	r = requests.get(url)
	data = r.text
	soup = BeautifulSoup(data, 'html.parser')
	opportunity_list = []
	opportunity_html = []

	for item in soup.find_all('a'):
		link = item.get('href')
		link_string = str(link)
		if link_string.startswith('/opportunity/'):
			#print(link_string)
			opportunity_list.append(link_string)
	print ('links found')

	for opp in opportunity_list:
		opp_url = 'https://www.laworks.com' + opp
		r = requests.get(opp_url)
		data = r.text
		soup = BeautifulSoup(data, 'html.parser')

		#print('\n\n NEW OPPORTUNITY \n\n')

		# div class_ = opportunity-banner-content
		# div class_ = organization-detail
		# h5: Volunteer Roles & Responsiblities (list items)
		# div class_ = express-interest-block template (for additional dates)
		# data-occ-start-date-time
		# data-occ-end-date-time

		title = str(soup.find(class_='opportunity-banner-content'))
		description = str(soup.find(class_='organization-detail'))

		opportunity_string = title + description
		opportunity_html.append(opportunity_string)

		#for item in soup:
		#	print(item)

	print(len(opportunity_html))



def main():
	volunteermatch_url = 'https://www.volunteermatch.org/search?l=Chicago%2C+IL%2C+USA'
	catchafire_url = 'https://www.catchafire.org/volunteer/'
	#from_volunteer_match(volunteermatch_url)
	from_catch_a_fire(catchafire_url)
	#from_la_works()


if __name__ == '__main__':
	main()





