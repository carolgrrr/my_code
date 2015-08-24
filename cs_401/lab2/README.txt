Carol Schmitz
CS 401: Lab 2

2.11 - The EqualsExamples programs prints out the results of one example of each of the five properties
an equals method override must satisfy. The results match the expectations so the overrride is valid.


2.12 - See EqualsTest.java for JUnit test case of equals method in FullTimeEmployee class



Lab 4: Randomness and Timing

Suppose we want to generate an array of n random Integer objects, where the value of n has already been read in, the random-number generator has been initialized from a seed of 500, and the underlying random ints are to be in the range 0 ... 99. We start with:
final int SEED = 500;

final int MAX = 100;

Random random = new Random (SEED);

Integer intArray[] = new Integer[n];

We then loop n times; during each loop iteration, we insert a random Integer object into the array.
Which of the following represents the correct for statement to insert the Integer objects?
a. for (int i = 0; i < n; i++)
	intArray [n] = new Integer (random.nextInt());
b. for (int i = 0; i < n; i++)
	intArray [i] = new Integer(random.nextInt());
c. for (int i = 0; i < n; i++)
	intArray [i] = new Integer (random.nextInt(MAX)); **correct answer
d. for (int i = 1; i <= n; i++)
	intArray [i] = new Integer(random.nextInt(MAX));

Quick Quiz
Recall that in the timer-skeleton from Chapter 3, we had:
final double NANO_FACTOR = 1000000000.0;  // nanoseconds per second
Suppose that for inserting n random Integers, the values for startTime and finishTime, respectively, are:
885161724000
889961724000

If the constant NANO_FACTOR had been defined as a long instead of a double, what number would be printed out for elapsedTime / NANO_FACTOR?
a. 4.8
b. 5
c. 4** correct answer
d. 4.000

HYPOTHESIZE
Carol answered in the following way:
Mystery1.class: O(log n)
Mystery2.class: O(2^n)
Mystery3.class: O(n log n)
Mystery4.class: O(n^2)


CONCLUDE

Carol answered in the following way:

Mystery1.class: O(log n)
n Value 		|	Elapsed-Time
n = 500000		|  0.053 seconds
n = 1000000  	|  0.101 seconds
____________________________________
n = 10000000	|	0.1316 seconds
n = 100000000	|	1.182594 seconds
n = 1000000000	|	11.929174 seconds

Mystery2.class: O(2^n)
n Value  	|	Elapsed-Time
n = 25  	|  	3.060 seconds
n = 26 	| 	 6.098 seconds
__________________________________
n = 25 	|	0.399841 seconds
n = 26	|	0.795941 seconds
n = 27	|	1.602137 seconds
n = 20 	|	0.01706 seconds
n = 30 	|	12.811298 seconds
n = 31	|	1.0E-6 seconds
n = 32	|	0.0 seconds

Mystery3.class: O(n log n)
n Value  		|	Elapsed-Time
n = 1000000 	|  	0.101 seconds
n = 2000000 	| 	0.099 seconds
________________________________________
n = 1000000		|	0.024159 seconds
n = 2000000		|	0.017076 seconds
n = 100000000	|	0.013384 seconds
n = 1000		|	0.016984 seconds
n = 100000		|	0.015883 seconds
n = 150000		|	0.015708 seconds

Mystery4.class: O(n^2)
n Value 		|	Elapsed-Time
n = 1000		| 	0.101 seconds
n = 2000		| 	0.363 seconds
________________________________________
n = 1000		|	0.022796 seconds
n = 2000		|	0.051526 seconds
n = 10000		|	1.189636 seconds
n = 500000		|	10.630493 seconds

The hardest part of the lab for me is noticing patterns within the very small input range. I received several Input Mismatch exceptions when trying to test very large values of n. As a result I had to infer the patterns within a smaller range of data, and the difference in results is so tiny that calculating the big O is quite tricky.