
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


def from_volunteer_match(input_url, location, savefile):

	base_url = 'https://www.volunteermatch.org/search/'
	end_virtual_url = ''

	if (location == 'Chicago'):
		print('searching for volunteer jobs in Chicago')
		base_url = input_url + 'Chicago%2C+ILA&o=recency&s='
	elif (location == 'Brooklyn'):
		print('searching for volunteer jobs in Brooklyn')
		base_url = input_url + 'Brooklyn%2C+NY&o=recency&s='
	elif (location == 'Los Angeles'):
		print('searching for volunteer jobs in Los Angeles')
		base_url = input_url + 'Los+Angeles%2C+CA&o=recency&s='
	elif (location == 'Oakland'):
		print('searching for volunteer jobs in Oakland')
		base_url = input_url + 'Oakland%2C+CA&o=recency&s='
	elif (location == 'Virtual'):
		print('searching for Virtual volunteer jobs')
		base_url = 'https://www.volunteermatch.org/search/index.jsp#k=&v=true&s='
		end_virtual_url = '1&o=distanceBand&l=San+Francisco%2C+CA%2C+USA&r=20&sk=&specialGroupsData.groupSize=&na=&partner=&usafc='




	#url = 'https://www.volunteermatch.org/'
	# search for jobs in chicago
	#base_url = input_url
	result_number = 1
	result_string = str(result_number)
	url = base_url + end_virtual_url
	#url = base_url + result_string
	#print_job_ids(base_url)

	#virtual_url: https://www.volunteermatch.org/search/index.jsp#k=&v=true&s=1&o=distanceBand&l=1600+N+Walnut+St%2C+Pittsburg%2C+KS+66762%2C+USA&r=20&sk=&specialGroupsData.groupSize=&na=&partner=&usafc=

	#virtual_url: https://www.volunteermatch.org/search/index.jsp#k=&v=true&s=1&o=distanceBand&r=20&sk=&specialGroupsData.groupSize=&na=&partner=&usafc=

	#             https://www.volunteermatch.org/search/index.jsp#k=&v=true&s=1&o=distanceBand&r=20&sk=&specialGroupsData.groupSize=&na=&partner=&usafc=
	#             https://www.volunteermatch.org/search/index.jsp#k=&v=true&s=11&o=distanceBand&l=San+Francisco%2C+CA%2C+USA&r=20&sk=&specialGroupsData.groupSize=&na=&partner=&usafc=
	#             https://www.volunteermatch.org/search/index.jsp#k=&v=true&s=21&o=distanceBand&l=San+Francisco%2C+CA%2C+USA&r=20&sk=&specialGroupsData.groupSize=&na=&partner=&usafc=


	#base_url = 'https://www.volunteermatch.org/search/?aff=&includeOnGoing=true&r=20.0&l=Chicago%2C+IL%2C+USA&o=recency&s='
	#run_print_function(base_url)

	id_set = set()
	id_set = get_job_ids(url, id_set)

	#actual number for all results: 1/15/18
	#while result_number < 1266:
	while result_number < 6832:
		full_url = base_url + result_string + end_virtual_url
		id_set = get_job_ids(full_url, id_set)
		result_number += 10
		result_string = str(result_number)

	print("there are %d volunteer jobs in %s" % (len(id_set), location))
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
	# "chicago-30-jobs.p"
	pickle.dump( opportunity_list, open(savefile, "wb" ) )
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

def get_opportunity_links(html, opportunity_links):
	for item in html.find_all('a'):
		link = item.get('href')
		link_string = str(link)
		if link_string.startswith('/volunteer/'):
			#print(link_string)
			opportunity_links.add(link_string)

	return opportunity_links


def from_catch_a_fire(input_url, savefile):

	r = requests.get(input_url+'/volunteer/')
	data = r.text
	soup = BeautifulSoup(data, 'html.parser')

	opportunities = set()
	opportunities = get_opportunity_links(soup, opportunities)
	pages = get_page_links(soup)

	for page in pages:
		#page = page[1:]
		url = input_url + '/volunteer/' + page
		response = requests.get(url)
		data = response.text
		soup = BeautifulSoup(data, 'html.parser')
		opportunities = get_opportunity_links(soup, opportunities)


	opportunity_list = []

	for opportunity in opportunities:
		opportunity_url = input_url + opportunity
		#print(opportunity_url)

		r = requests.get(opportunity_url)
		data = r.text
		soup = BeautifulSoup(data, 'html.parser')

		opportunity_list.append(str(soup))

		'''
		cards = soup.find_all(class_="card-list")

		for card in cards:
			if len(card) > 0:
				listitem = card.li.text
				if listitem is not None:
					card_string = str(card.li.text)
					if card_string.startswith('Estimated Time:'):
						#print(card_string)
						duration = card_string
				else:
					duration = 'NA'

		organization = str(soup.find_all(class_='project-meta-name'))
		category = str(soup.find_all(class_="badge badge-caf-red"))

		opportunity_string = ""
		opportunity_string += title
		opportunity_string += organization
		opportunity_string += summary


		#duration_string = str(cards[0])
		#if duration_string.startswith('Estimated Time:'):
		#	print(duration_string)
		#print(cards[0])
		#print(len(cards))
		'''

	pickle.dump( opportunity_list, open(savefile, "wb" ) )
	# organization
	#for b in soup.find_all(class_="project-meta-name"):
	#	print(b.text)

	# how to tell if job is virtual or at a specific location?

	# duration, location, state
	#cards = soup.find_all(class_="card-list")


	"""
	for tag in soup.find_all(class_="card-list"):
		#print(tag)
		#print(tag.li.text)
		city = str(tag.li.text)
		print(city)
		if city.startswith('Estimated Time:'):

		if city.endswith("USA"):
			state = city[-6:-4]
			print(state)
		else:
			state = 'NA'
		print(state)
		# if text ends in ", USA" then state = 2 letters before the comma

	# category
	#for b in soup.find_all(class_="badge badge-caf-red"):
	#	print(b.text)
	#print(soup)
	#print(opportunities)

	#print(opportunity)
"""




	#for item in soup.find_all('a'):
	#	link = item.get('href')
	#	link_string = str(link)
	#	if link_string.startswith('/volunteer/'):
	#		#print(link_string)
	#		opportunies.add(link_string)
	#	#elif link_string.startswith('?/page='):
	#	#	print(link_string)
	#	#	page_list.append(link_string)
	#print ('links found')

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

def from_sponsorchange(url, savefile):
	r = requests.get(url)
	data = r.text
	soup = BeautifulSoup(data, 'html.parser')

	links = soup.find_all('a')

	for link in links:
		url = link.get('href')
		print(link.get('href'))

	#print(soup)

	#pickle.dump(soup, open(savefile, 'wb'))
	#pickle.dump( opportunity_list, open(savefile, "wb" ) )





def main():
	volunteermatch_url = 'https://www.volunteermatch.org/search?l=Chicago%2C+IL%2C+USA'
	catchafire_url = 'https://www.catchafire.org'
	sponsorchange_url = 'http://www.sponsorchange.org/?page_id=144'

	#other options: LA, Oakland, Brooklyn
	location = 'Chicago'

	volunteermatch_filename = 'chicago-30-jobs.p'
	#volunteermatch_filename = 'volunteermatch-chicago-jobs.csv'
	catchafire_filename = 'catchafire-jobs.p'
	sponsorchange_filename = 'sponsorchange-jobs.p'

	#from_volunteer_match(volunteermatch_url, location, volunteermatch_filename)
	#from_catch_a_fire(catchafire_url, catchafire_filename)
	#from_la_works()
	from_sponsorchange(sponsorchange_url, sponsorchange_filename)


if __name__ == '__main__':
	main()





