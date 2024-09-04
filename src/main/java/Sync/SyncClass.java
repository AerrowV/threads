package Sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncClass {

    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void method1() {
        // Acquire lock1 first
        lock1.lock();
        System.out.println(Thread.currentThread().getName() + " acquired lock1 in method1");

        try {
            // Simulate some processing
            Thread.sleep(100);
            // Now attempt to acquire lock2
            System.out.println(Thread.currentThread().getName() + " attempting to acquire lock2 in method1");
            lock2.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock2 in method1");
                // Call method2 which will try to acquire lock1 again
                method2();
            } finally {
                lock2.unlock();
                System.out.println(Thread.currentThread().getName() + " released lock2 in method1");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
            System.out.println(Thread.currentThread().getName() + " released lock1 in method1");
        }
    }

    public void method2() {
        // Acquire lock2 first
        lock2.lock();
        System.out.println(Thread.currentThread().getName() + " acquired lock2 in method2");

        try {
            // Simulate some processing
            Thread.sleep(100);
            // Now attempt to acquire lock1
            System.out.println(Thread.currentThread().getName() + " attempting to acquire lock1 in method2");
            lock1.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock1 in method2");
            } finally {
                lock1.unlock();
                System.out.println(Thread.currentThread().getName() + " released lock1 in method2");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
            System.out.println(Thread.currentThread().getName() + " released lock2 in method2");
        }
    }

    public static void main(String[] args) {
        SyncClass syncClass = new SyncClass();

        Thread thread1 = new Thread(() -> syncClass.method1(), "Thread-1");
        Thread thread2 = new Thread(() -> syncClass.method2(), "Thread-2");

        thread1.start();
        thread2.start();
    }
}
