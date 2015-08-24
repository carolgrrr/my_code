# Problem 1 - Multiples of 3 and 5

# If we list all the natural numbers below 10 that are multiples of 3 or 5, 
# we get 3, 5, 6 and 9. The sum of these multiples is 23.

# Find the sum of all the multiples of 3 or 5 below 1000.

# to solve the problem, enter 1000 at the prompt
number = input ('Please enter a number: ')
sum = 0

# consider every number from 1 to the input number
for x in range(1, number):
	# add multiples of 3 to sum
	if x % 3 == 0:
		sum = sum + x
	# add multiples of 5 that are not also multiples of 3 to sum
	elif x % 5 == 0:
		sum = sum + x

# output solution
print "The sum of all multiples of 3 or 5 below", number, "is", sum