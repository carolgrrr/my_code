Carol Schmitz
CS 401 - Fall 2013


6.4 Hypothesize what will happen when the following code fragment is run, and then test your hypothesis:


ArrayList<String> original = new ArrayList<String>();
original.add(“yes”);
ArrayList<Integer> copy = (ArrayList<Integer>)original.clone();


System.out.println (copy.get (0));


Hint: This exercise illustrates why the copy constructor is superior to the clone () method.


When this code is run, the string “yes” is added to the original ArrayList. Then a copy of the original is created by using the clone method. The object at index 0 of the copy is printed to the console, which in this case is the string “yes”. When I tested this code, I saw “yes” printed to the console as expected. This is because the clone method does not assure type safety, so the ArrayList of type Integer actually contains an element of type String. In this case there aren’t any consequences, but in a more complex program the clone method could produce some unexpected results.


6.12
Suppose we create the following ArrayList instance:
        ArrayList<String> words = new ArrayList<String>();


And then we insert several words into words. Write the code to print out each element of words that has exactly four letters. You should have three different versions of the code:
a. using an index;
b. using an explicit iterator;
c. using an enhanced for statement.


See lab4.java


6.13
Test and define the following method
/**
* In a given ArrayList, remove all duplicates.
* The worstTime(n) is O(n2).
*
* @param list - the given ArrayList.
* @return - An ArrayList that is identical to list except only the first
* occurrence of duplicate elements remains.
*
* @throws NullPointerException - if list is null.
*
*/
public static <T> ArrayList <T> uniquefy (ArrayList <T> list)


See lab4.java


Lab 10


Quick Quiz: Now, if we were to:
myList.add (3, "hello");
System.out.println(myList);

What will the output be?
a. [yes, maybe, blue, hello, red] *
b. [yes, maybe, blue, 3, red]
c. [yes, maybe, hello, blue, red]
d. [yes, maybe, blue, hello, hello]