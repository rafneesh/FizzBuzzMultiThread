package com.rafneesh.fizzbuzz;

import com.rafneesh.fizzbuzz.solution.FizzBuzz;

public class Application {

    public static void main(String[] args) {

        testFizzBuzz();

    }

    private static void testFizzBuzz() {


        FizzBuzz fizzBuzz = new FizzBuzz(3);

        Runnable fizz = () -> System.out.print("fizz");
        Runnable buzz = () -> System.out.print("buzz");
        Runnable fBuzz = () -> System.out.print("fizzbuzz");


        new Thread(() -> {

            try {
                fizzBuzz.fizz(fizz);
            } catch (InterruptedException e) {

                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {

            try {
                fizzBuzz.buzz(buzz);
            } catch (InterruptedException e) {

                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {

            try {
                fizzBuzz.fizzbuzz(fBuzz);
            } catch (InterruptedException e) {

                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {

            try {
                fizzBuzz.number(System.out::print);
            } catch (InterruptedException e) {

                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }).start();
    }
}
