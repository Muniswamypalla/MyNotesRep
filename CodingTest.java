package com.arya.intprog;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CodingTest {
    public static String SPACE = " ";

    public static void main(String[] args) {
        solution1();
        // solution2Java8();
    }

    private static void solution1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter X and Y values:");
        String xAndy[] = scanner.nextLine().trim().split(SPACE);
        int X = Integer.parseInt(xAndy[0]);
        int arr[] = new int[X];
        int Y = Integer.parseInt(xAndy[1]);
        int maxValue = 0;

        for (int a = 0; a < Y; a++) {
            System.out.println("Please enter i j k values: ");
            String ijk[] = scanner.nextLine().trim().split(SPACE);
            int i = Integer.parseInt(ijk[0]);
            int j = Integer.parseInt(ijk[1]);
            int k = Integer.parseInt(ijk[2]);

            for (int b = i - 1; b < j; b++) {
                arr[b] += k;
                if (arr[b] > maxValue) {
                    maxValue = arr[b];
                }
            }
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("Max Value: " + maxValue);
    }

    private static void solution2Java8() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter X and Y values:");
        String xAndy[] = scanner.nextLine().trim().split(SPACE);
        int X = Integer.parseInt(xAndy[0]);
        int arr[] = new int[X];
        int Y = Integer.parseInt(xAndy[1]);
        int max = 0;

        for (int a = 0; a < Y; a++) {
            System.out.println("Please enter i j k values: ");
            String ijk[] = scanner.nextLine().trim().split(SPACE);
            int i = Integer.parseInt(ijk[0]);
            int j = Integer.parseInt(ijk[1]);
            int k = Integer.parseInt(ijk[2]);
            Integer[] integers = IntStream.range(i - 1, j).mapToObj(in -> arr[in] += k).toArray(Integer[]::new);
            System.out.println(Arrays.toString(arr));
        }

        int maxValue = Arrays.stream(arr).map(val -> val).max().orElse(0);
        System.out.println("Max Value: " + maxValue);
    }

}
