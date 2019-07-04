package com.challenge2_4;

import java.util.*;

public class LCM {
    private static long lcm_naive(int a, int b) {

        return (long)a * (long)b /gcd_naive(a, b);
    }
    private static int gcd_naive(int a, int b) {
        if (a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        if (b == 0) {
            return b;
        }
        while(a % b != 0){
            int temp = b ;
            b = a % b;
            a = temp;
        }
        return b;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm_naive(a, b));
    }
}

