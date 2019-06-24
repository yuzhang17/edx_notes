package com.challenge2_3;

import java.util.*;

public class GCD {
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

        System.out.println(gcd_naive(a, b));
    }
}

