package com.rafneesh.fizzbuzz.solution;

import java.util.concurrent.locks.Lock;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private final int n;
    private int currentValue = 1;
    private final Lock lock = new java.util.concurrent.locks.ReentrantLock();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {

        while (currentValue <= n) {

            lock.lock();
            try {
                if (currentValue <= n && (currentValue % 3 == 0 && currentValue % 5 != 0)) {

                    printFizz.run();
                    currentValue++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (currentValue <= n) {

            lock.lock();
            try {
                if (currentValue <= n && (currentValue % 3 != 0 && currentValue % 5 == 0)) {

                    printBuzz.run();
                    currentValue++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (currentValue <= n) {

            lock.lock();
            try {
                if (currentValue <= n && (currentValue % 3 == 0 && currentValue % 5 == 0)) {

                    printFizzBuzz.run();
                    currentValue++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

        while (currentValue <= n) {

            lock.lock();
            try {
                if (currentValue <= n && (currentValue % 3 != 0 && currentValue % 5 != 0)) {

                    printNumber.accept(currentValue);
                    currentValue++;
                }
            } finally {
                lock.unlock();
            }
        }

    }
}