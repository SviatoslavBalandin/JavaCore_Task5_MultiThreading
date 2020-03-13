package com.company;

public class Main {

    public static void main(String[] args) {

        showTimeOfComputingArray();
       // showTimeOfComputingArrayByMultiThreading();
    }

    private static void showTimeOfComputingArray () {
        float[] array = getMillionLengthArray();
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Execution time - " + (System.currentTimeMillis() - start));
    }

    private static float[] getMillionLengthArray () {
        final int size = 1000000;
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = 1;
        }
        return array;
    }
}
