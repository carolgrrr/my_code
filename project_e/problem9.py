# Problem 9 - Special Pythagorean triplet

# A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
# a^2 + b^2 = c^2
# For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

# There exists exactly one Pythagorean triplet for which a + b + c = 1000.
# Find the product a * b * c.

import math

# number = input("Enter a number: ")

for a in range (0, 1000):
	for b in range(0, 1000):
		# store a squared plus b squared in k
		k = (a*a) + (b*b)

		# check if the square root of k is a natural number
		if math.sqrt(k) % 1 == 0:
			# if so, store the square root of a squared plus b squared in c
			c = math.sqrt(k)
			# check if all numbers are greater than zero and their sum is 1000
			if a != 0 and b != 0 and a + b + c == 1000:
				# output solution
				product = a * b * c
				print "In the winning triple, a is", a, "b is", b, "c is", c
				print "The product is:", product