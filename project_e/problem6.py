# The sum of the squares of the first ten natural numbers is,

# 1^2 + 2^2 + ... + 10^2 = 385
# The square of the sum of the first ten natural numbers is,

# (1 + 2 + ... + 10)^2 = 552 = 3025
# Hence the difference between the sum of the squares of the first ten natural 
# numbers and the square of the sum is 3025 - 385 = 2640.

# Find the difference between the sum of the squares of the first one hundred 
# natural numbers and the square of the sum.

# initialize variables to 0
sum_of_squares = 0
square_of_sums = 0
sum_one_to_ten = 0
difference = 0

# natural numbers from 1 to 100
for i in range(1, 101):
	# add the square of each natural number to the sum of squares
	sum_of_squares = sum_of_squares + (i * i)
	# add each natural number to the sum of natural numbers
	sum_one_to_ten = sum_one_to_ten + i

square_of_sums = sum_one_to_ten * sum_one_to_ten
difference = square_of_sums - sum_of_squares

print "The sum of squares is:", sum_of_squares
print "The square of sums is:", square_of_sums
print "The difference between the two is:", difference