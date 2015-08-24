final String MESSAGE_1 = "The elapsed time was ";

final double NANO_FACTOR = 1000000000.0;  // nanoseconds per second

final String MESSAGE_2 = " seconds.";

long startTime,
     finishTime,
     elapsedTime;

startTime = System.nanoTime();

// Perform the task:


// Calculate the elapsed time:
finishTime = System.nanoTime();
elapsedTime = finishTime - startTime;
System.out.println (MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
