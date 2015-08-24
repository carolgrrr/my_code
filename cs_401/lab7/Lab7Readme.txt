CS401QueueArrayFixedImpl.class:
If the back equals capacity, the queue is full and elements cannot be added. If back equals 0, the queue is empty and elements cannot be removed. This class adds elements to the back of an array until it reaches capacity, and removes elements until the array is empty. 


CS401QueueArrayFloatingImpl.class:
If the element in the back index of the data array is not null, the queue is full and elements cannot be added. If the element in the front index of the data array is null, the queue is empty and elements cannot be removed. The add and remove methods work the same except instead of strictly incrementing and decrementing the counters, we use modular arithmetic to allow the front and back of the array to float to different indices of the array.


CS401QueueLinkedListImpl.class:
I added a field to keep track of the maximum number of elements allowed in the list, otherwise the is_full method has no context. I also created constructors for Queues with and without a maximum number of elements. The add method adds new elements to the back of the queue by setting the tail’s next pointer to the new element, and then pointing tail to the new element. The remove element removes the first element in the queue by setting a temporary element to the head and then moving the head pointer to the head’s next pointer. 


QueueTest.class:
This test class creates one of each type of queue, adds some String elements to each, and then removes an element from each. 


Programming Project 8.1


In order to modify the Car Wash simulation so that the arrival times and service times are randomly generated, I modified the Car class to add a washTime field and a method to retrieve the value stored in this field. This way the randomly generated service time can be stored with the Car object in the service queue so that we know when to remove that Car from the queue. I also modified the CarWash class. I added variables to store the Mean Service Time, Mean Arrival Time, and the count of the number of Overflow events, and made the constructor set assign the value 0 to these variables. I created 2 methods to randomly generate the arrival and service times of each car given the means, as well as accessor and mutator methods for some of the new variables.


I then modified each of the Process methods to use the randomly generated values for Wash Time instead of the constant 10 minutes of the original program. I incremented the Overflow Counter by 1 each time an Overflow event occurs, and modified the output strings to match the specifications of the problem. I also had to modify the User class. This involved changing the input prompts, and making the simulation repeat until the Next Arrival Time is beyond the user-defined maximum. 


This is a sample output of the program run a few times with the same inputs:


ROUND 1
Please enter the mean arrival time: 4


Please enter the mean service time: 8


Please enter the maximum arrival time: 34


Here are the results of the simulation:




Time        Event                Waiting Time


1        Arrival


6        Arrival


8        Arrival


8        Arrival


13        Arrival


18        Arrival


19        Arrival (Overflow)


28        Departure                0


37        Departure                22


39        Departure                29


45        Departure                31


49        Departure                32


56        Departure                31




The average waiting time was 24.2 minutes per car. 
The average queue length was 2.6 cars per minute. 
The number of overflows was 1. 






ROUND 2
Please enter the mean arrival time: 4


Please enter the mean service time: 8


Please enter the maximum arrival time: 34


Here are the results of the simulation:




Time        Event                Waiting Time


0        Arrival


7        Arrival


10        Departure                0


13        Arrival


14        Arrival


14        Arrival


15        Departure                3


15        Arrival


17        Arrival


19        Departure                2


25        Departure                5


27        Arrival


27        Arrival


28        Arrival


30        Departure                11


31        Arrival


34        Arrival (Overflow)


36        Departure                15


41        Departure                19


42        Departure                14


42        Departure                15


79        Departure                14


91        Departure                48




The average waiting time was 13.3 minutes per car. 
The average queue length was 1.6 cars per minute. 
The number of overflows was 1. 




Programming Project 8.2


Design, Test, and Implement a Program to Evaluate a Condition


I used two methods from my test class in the last lab, with modifications, as the basis for this problem. Once I was able to convert an infix expression to postfix, and then evaluate the expression, I had to figure out how to handle variables. I created two ArrayLists: symbolTable, to hold the variable names from the condition as strings, and and values to hold the values input by the user for each variable. Each time a variable is encountered in the condition, it is added to symbolTable. Then the size of symbolTable is used to prompt the user for the correct number of values. Once these values have been stored in the values ArrayList, they are replaced in the postfix condition and then the condition is evaluated. The result is printed to the console.


Here are some sample inputs/outputs:


Please enter a condition, or $ to quit: a * b > a + a
Please enter a value: 4
Please enter a value: 5


The value of the condition is true


Please enter a condition, or $ to quit: b * a  a + c
Please enter a value: 6
Please enter a value: 2
Please enter a value: 7


The value of the condition is true


Please enter a condition, or $ to quit: current * (next - previous) == next + current * i
Please enter a value: 3
Please enter a value: 5
Please enter a value: 3
Please enter a value: 2


The value of the condition is false


Please enter a condition, or $ to quit: $