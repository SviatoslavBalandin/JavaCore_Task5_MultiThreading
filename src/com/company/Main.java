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
    private static void showTimeOfComputingArrayByMultiThreading () {
        float[] array = getMillionLengthArray();
        int half = array.length / 2;
        long start = System.currentTimeMillis();
        float[] firstArray = new float[half];
        float[] secondArray = new float[half];
        System.arraycopy(array, 0, firstArray, 0, half);
        System.arraycopy(array, half, secondArray, 0, half);
        Thread t1 = new Thread(() -> {for (int i = 0; i < half; i++) {
            firstArray[i] = (float) (firstArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }});
        Thread t2 = new Thread(() -> {for (int i = 0; i < half; i++) {
            secondArray[i] = (float) (secondArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }});

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
