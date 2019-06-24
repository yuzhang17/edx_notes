package com.challenge2_1;

import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib(int n) {
        int first = 0;
        int second = 1;
        if (n == 0){
            return first;
        }
        for (int i = 2; i <= n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}
