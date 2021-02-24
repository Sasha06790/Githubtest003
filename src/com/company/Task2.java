package com.company;

public class Main1 {

    public static final int LENGTH = 6;

    public static void main(String[] args) {
        System.out.println("Всего " + count() + " \"счастливых\" билета");
    }

    private static int count() {
        int[] arr = new int[LENGTH];
        int counter = 0;
        for (int i = 100000; i < Math.pow(10, LENGTH); i++) {
            int[] numberSplitter = numberSplitter(i);
            int[] digitExtractor1 = digitExtractor(numberSplitter[0]);
            int[] digitExtractor2 = digitExtractor(numberSplitter[1]);
            int sum1 = 0;
            int sum2 = 0;
            sum1 += digitExtractor1[0];
            while (digitExtractor1[1] > 0) {
                digitExtractor1 = digitExtractor(digitExtractor1[1]);
                sum1 += digitExtractor1[0];
            }
            sum2 = sum2 + digitExtractor2[0];
            while (digitExtractor2[1] > 0) {
                digitExtractor2 = digitExtractor(digitExtractor2[1]);
                sum2 += digitExtractor2[0];
            }
            if (sum1 == sum2) {
                System.out.println(i);
                counter++;
            }
        }
        return counter;
    }

    private static int[] numberSplitter(int i) {
        int[] result = new int[2];
        int firstHalf = i / 1000;
        int lastHalf = i % 1000;
        result[0] = firstHalf;
        result[1] = lastHalf;
        return result;
    }

    private static int[] digitExtractor(int i) {
        int[] result = new int[2];
        int lastDigit = i % 10;
        int remainingNumber = i / 10;
        result[0] = lastDigit;
        result[1] = remainingNumber;
        return result;
    }

}
