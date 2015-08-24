1. Lecture 5 material contains the CS401LinkedListImpl.java class. Fill in the body of the remove() method in the iterator and submit the source code with a test program that demonstrates your code actually does remove the element under the iterator.
To test your code, use the following test cases:
a) Create a linked list with one entry on it. Position the iterator on top of this entry and delete it. Your linked list should now be empty.
b) Create a linked list with two entries on it. Position the iterator on top of the first entry and delete it. Your linked list should have one element (or entry) now. Print this element.
c) Create a linked list with two elements. Position the iterator on top of the last entry and delete it. Your linked list should have one element now. Print this element.
d) Create a linked list with three elements. Position the iterator on the middle element and delete it. Your linked list should now have two entries. Print the linked list.


Sample output:
List contains:
first entry


After remove, list contains: 
null


List contains:
first entry
second entry


After remove, list contains: 
second entry


List contains:
second entry
third entry


After remove, list contains:
second entry


List contains:
second entry
third entry
fourth entry


After remove, list contains:
second entry
fourth entry




Note: code files for 2, 3, and 4 are in folder num2_3_4


2. Fill in the missing code in CS401DblLinkedListImpl.java as   indicated in the class lecture.
To test your code, create a doubly linked list and enter the  following elements of type String in it:
      Bill, Rohan, James, Krishna, Javier, Lisa
(a) Print the linked list starting at the beginning. 
(b) Print the linked list starting at the end. 
(c) Remove Bill and print the linked list starting from beginning. 
(d) Remove Lisa and print the linked list starting from end. 
(e) Remove Krishna and print the linked list starting from the beginning.
See file dblLinkedListTest.java for test code. This is the output of that test class:
List printed from beginning: 
Bill
Rohan
James
Krishna
Javier
Lisa


List printed from end: 
Lisa
Javier
Krishna
James
Rohan
Bill


Remove element: Bill
New list printed from beginning: 
Rohan
James
Krishna
Javier
Lisa


Remove element: Lisa
New list printed from end: 
Javier
Krishna
James
Rohan


Remove element: Krishna
New list printed from beginning: 
Rohan
James
Javier




3. Implement stacks using the template given in the following Java   files:
   CS401StackInterface.java CS401StackLinkedListImpl.java
I did not change anything in the interface, but I did add a few extra methods to CS401StackLinkedListImpl.java beyond push, pop and size. I created getHead(), a method to return the head link entry, and printElements(), a method to print out each element in the stack. These additional methods were useful for #4.


4. Infix to postfix evaluation: Using the Stack class developed in  the previous assignment, evaluate the following expressions.  Note that you have to first change these infix expressions to  postfix expressions as discussed in the book and the class  lecture.  Once you have a postfix expression, evaluate it using  the Stack class to get the result as discussed in the lecture.  Use the Java Scanner class to input the postfix expression for  evaluation.
Here is the input data: 
(1) 1 + 3 * 8 
(2) 8 - 2 + 8 / 4 + 6 - 1 - 6 / 2
(3) 8 - 3 - 4 * 6 + 3 
(4) 1 + 9 * 2 - 2 + 3 / 4 + 3 - 4 * 3 + 4
See file StackTest.java for test code. This is the output of the test class:


Enter your infix expression (or -1 to quit): 1 + 3 * 8
Postfix expression: 1 3 8 * +
Expression evaluated: 25


Enter your infix expression (or -1 to quit): 8 - 2+ 8 / 4 + 6 - 1 - 6 / 2
Postfix expression: 8 2 - 8 4 / + 6 + 1 - 6 2 / -
Expression evaluated: 10


Enter your infix expression (or -1 to quit): 8 - 3 - 4 * 6 + 3
Postfix expression: 8 3 - 4 6 * - 3 +
Expression evaluated: -16


Enter your infix expression (or -1 to quit): 1 + 9 * 2 - 2 + 3 / 4 + 3 - 4 * 3 + 4
Postfix expression: 1 9 2 * + 2 - 3 4 / + 3 + 4 3 * - 4 +
Expression evaluated: 12.75


Enter your infix expression (or -1 to quit): -1