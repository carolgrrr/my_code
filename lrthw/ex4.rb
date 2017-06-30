# Assign the value 100 to the variable named cars
cars = 100
# Assign the value 4.0 to the variable named space_in_a_car
space_in_a_car = 4.0
# Assign the value 30 to the variable named drivers
drivers = 30
# Assign the value 90 to the variable named passengers
passengers = 90
# Assign the difference between the value stored in the variable named cars and the value stored in the variable named drivers to the variable named cars_not_driven
cars_not_driven = cars - drivers
# Assign the value stored in the variable named drivers to the variable named cars_driven
cars_driven = drivers
# Assign the product of the value stored in the variable named cars_driven and the value stored in the variable named space_in_a_car to the variable named carpool_capacity
carpool_capacity = cars_driven * space_in_a_car
# Assign the quotient of the value stored in the variable named passengers and the value stored in the variable named cars_driven to the variable named average_passengers_per_car
average_passengers_per_car = passengers / cars_driven


# Print the value stored in the variable named cars in a sentence
puts "There are #{cars} cars available."
# Print the value stored in the variable named drivers in a sentence
puts "There are only #{drivers} drivers available."
# Print the value stored in the variable named cars_not_driven in a sentence
puts "There will be #{cars_not_driven} empty cars today."
# Print the value stored in the variable named carpool_capacity in a sentence
puts "We can transport #{carpool_capacity} people today."
# Print the value stored in the variable named passengers in a sentence
puts "We have #{passengers} to carpool today."
# Print the value stored in the variable named average_passengers_per_car in a sentence
puts "We need to put about #{average_passengers_per_car} in each car."