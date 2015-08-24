# Problem 4 - Largest Palindrome Product

# A palindromic number reads the same both ways. 
# The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 * 99.

# Find the largest palindrome made from the product of two 3-digit numbers.

# returns true if the string passed is a palindrome 
# returns false if not
# only works for 5- and 6-digit strings
def isPalindrome(string):
	length = len(string)

	# compare first and last characters of number string
	# compare second and second to last characters of number string
	# compare third and third to last (possibly same character) characters of number string
	if(string[0] == string[length-1] and string[1] == string[length-2] and string[2] == string[length-3]):
		# if all three pairs are the same, the string is a palindrome
		return True
	else:
		return False

# initialize variable to hold largest palindrome
largest = 0

# cycle through largest 3-digit numbers
for i in range(999, 900, -1):
	for j in range(999, 900, -1):
		# multiply them
		product = i * j
		# convert number to string
		product_string = str(product)

		# the largest palindrome will have at least 6-digits
		if product > 99999:
			
			if isPalindrome(product_string):
				if product > largest:
					largest = product
				#print i, "*", j, "=", product_string
				#print product_string, "is a palindrome."

print "The largest palindrom is", largest

