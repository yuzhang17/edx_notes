package com.challenge3_4;

import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        Arrays.sort(segments);
        for (Segment segment : segments) {
            System.out.println(segment.start);
        }
        ArrayList<Integer> points = new ArrayList<>();

        for (int i = 0; i < segments.length; i++) {
            int curVal = segments[i].start;
            int j = i + 1;
            for (; j < segments.length && segments[j].start < segments[i].end ; j++) {

                    if (curVal < segments[j].start){
                        curVal = segments[j].start;
                    }
            }
            points.add(curVal);
            i = j;

        }
        int[] res = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            res[i] = points.get(i);
        }
        return res;
    }

    private static class Segment implements Comparable<Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment o) {
            return this.start - o.start;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}

