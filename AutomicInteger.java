// AtomicInteger is used to perform the atomic operation over an integer, its an alternative when you don't want to use synchronized keyword.
//AtomicInteger consistently gets the right answer

import java.util.ArrayList;
  import java.util.List;
  import java.util.concurrent.atomic.AtomicInteger;

  public class Test {
    private static int COUNTS_PER_THREAD = 1000000;
    private static int THREADS = 2;

    private static int count = 0;
    private static volatile int volatileCount = 0;
    private static AtomicInteger atomicCount = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
      List<Thread> threads = new ArrayList<Thread>(THREADS);
      for (int i = 0; i < THREADS; i++) {
        threads.add(new Thread(new Counter()));
      }
      for (Thread t : threads) {
        t.start();
      }
      for (Thread t : threads) {
        t.join();
      }
      System.out.println("count: " + count +  " volatileCount: " + volatileCount + " atomicCount: "
          + atomicCount + " Expected count: "
          + (THREADS * COUNTS_PER_THREAD));
    }

    private static class Counter implements Runnable {
      @Override
      public void run() {
        for (int i = 0; i < COUNTS_PER_THREAD; i++) {
          count++;
          volatileCount++;
          atomicCount.incrementAndGet();
        }
      }
    }
  }

========

class Counter extends Thread { 
  
    // Counter Variable 
    int count = 0; 
  
    // method which would be called upon 
    // the start of execution of a thread 
    public void run() 
    { 
        int max = 1_000_00_000; 
  
        // incrementing counter 
        // total of max times 
        for (int i = 0; i < max; i++) { 
            count++; 
        } 
    } 
} 
  
public class UnSafeCounter { 
    public static void main(String[] args) 
        throws InterruptedException 
    { 
        // Instance of Counter Class 
        Counter c = new Counter(); 
  
        // Defining Two different threads 
        Thread first = new Thread(c, "First"); 
        Thread second = new Thread(c, "Second"); 
  
        // Threads start executing 
        first.start(); 
        second.start(); 
  
        // main thread will wait for 
        // both threads to get completed 
        first.join(); 
        second.join(); 
  
        // Printing final value of count variable 
        System.out.println(c.count); 
    } 
} 


In a single thread environment, the above-mentioned class will give the expected result only. But when a multithreaded environment is concerned, it may lead to inconsistent results. It happens because updating “var” is done in three steps: Reading, updating, and writing. If two or more threads try to update the value at the same time, then it may not update properly.

This issue can be solved using Lock and Synchronization, but not efficiently.

Using lock analogy or synchronization: Synchronization or Locking can solve our problem, but it compromises time efficiency or performance. First, it mandates resource and thread scheduler to control lock. Second, when multiple threads attempt to acquire a lock, only one of them wins, rest are suspended or blocked. Suspending or blocking of threads can have a huge impact on performance.

import java.io.*; 
import java.util.concurrent.locks.*; 
  
class Counter extends Thread { 
  
    // Counter Variable 
    int count = 0; 
  
    // method which would be called upon 
    // the start of execution of a thread 
    public synchronized void run() 
    { 
  
        int max = 1_000_00_000; 
  
        // incrementing counter total of max times 
        for (int i = 0; i < max; i++) { 
            count++; 
        } 
    } 
} 
  
public class SynchronizedCounter { 
    public static void main(String[] args) 
        throws InterruptedException 
    { 
        // Instance of Counter Class 
        Counter c = new Counter(); 
  
        // Defining Two different threads 
        Thread first = new Thread(c, "First"); 
        Thread second = new Thread(c, "Second"); 
  
        // Threads start executing 
        first.start(); 
        second.start(); 
  
        // main thread will wait for both 
        // threads to complete execution 
        first.join(); 
        second.join(); 
  
        // Printing final value of count variable 
        System.out.println(c.count); 
    } 
} 

Using Atomic variable:

import java.util.concurrent.atomic.AtomicInteger; 
  
class Counter extends Thread { 
  
    // Atomic counter Variable 
    AtomicInteger count; 
  
    // Constructor of class 
    Counter() 
    { 
        count = new AtomicInteger(); 
    } 
  
    // method which would be called upon 
    // the start of execution of a thread 
    public void run() 
    { 
  
        int max = 1_000_00_000; 
  
        // incrementing counter total of max times 
        for (int i = 0; i < max; i++) { 
            count.addAndGet(1); 
        } 
    } 
} 
  
public class AtomicCounter { 
    public static void main(String[] args) 
        throws InterruptedException 
    { 
        // Instance of Counter Class 
        Counter c = new Counter(); 
  
        // Defining Two different threads 
        Thread first = new Thread(c, "First"); 
        Thread second = new Thread(c, "Second"); 
  
        // Threads start executing 
        first.start(); 
        second.start(); 
  
        // main thread will wait for both 
        // threads to complete execution 
        first.join(); 
        second.join(); 
  
        // Printing final value of count variable 
        System.out.println(c.count); 
    } 
} 
