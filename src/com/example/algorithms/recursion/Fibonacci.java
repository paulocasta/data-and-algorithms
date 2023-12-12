package com.example.algorithms.recursion;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
    private static int fib(int i) {
        if (i <= 1) {
            return 1;
        }
        return fib(i -1) + fib(i - 2);
    }
}
