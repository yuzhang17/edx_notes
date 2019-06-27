package com.challenge3_2;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        Spicy[] spicies = new Spicy[values.length];
        for (int i = 0; i < values.length; i++) {
            spicies[i] = new Spicy(weights[i], values[i]);
        }
        Arrays.sort(spicies);
        for (Spicy spicy : spicies) {
        System.out.println(spicy.value);

        }
        for (int i = 0; i < spicies.length && capacity != 0; i++) {
            if (capacity > spicies[i].weight){
                capacity = capacity - spicies[i].weight;
                value += spicies[i].value;
            }else {
                value += ((double) capacity/(double) spicies[i].weight)*(double) spicies[i].value;
                capacity = 0;
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}

class Spicy implements Comparable<Spicy> {
     int weight;
     int value;

    public Spicy(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }



    @Override
    public int compareTo(Spicy o) {
      double res =  (double)this.value/(double) this.weight - (double) o.value/(double) o.weight;
      if (res > 0) {
          return -1;
        }
      else if (res < 0 ){
          return 1;
      }
      else{
          return 0;
      }
    }
}