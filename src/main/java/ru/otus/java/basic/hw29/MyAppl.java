package ru.otus.java.basic.hw29;

import java.util.Arrays;

public class MyAppl {
    public static void main(String[] args) {
        int[] array1 = {1, 1, 2, 1, 2, 4, 5};
        int[] array2 = {2, 2};
        int[] array3 = {2, 3};
        int[] array4 = {1, 2, 2, 1};
        try {
            System.out.println(Arrays.toString(getArrayAfterOne(array2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("array1: " + isPresenceOneTwo(array1));
        System.out.println("array2: " + isPresenceOneTwo(array2));
        System.out.println("array3: " + isPresenceOneTwo(array3));
        System.out.println("array4: " + isPresenceOneTwo(array4));
    }

    public static boolean isPresenceOneTwo(int[] arr) {
        int countOne = 0;
        int countTwo = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > 2) return false;

            if( arr[i] == 1) countOne++;
            if( arr[i] == 2) countTwo++;
        }
        if( countOne == 0 || countTwo== 0 ) return false;
        return true;
    }

    public static int[] getArrayAfterOne(int[] arr)  {

        int[] inverted = new int[arr.length];
        int element = 0;
        int pos = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                pos = i;
                break;
            }
            inverted[element] = arr[i];
            element++;
        }
        if (pos < 0) {
            throw new RuntimeException("В массиве  нет 1");
        }
        int[] arrayResult = new int[element];
        int j = 0;
        for (int i = element - 1; i >= 0; i--) {
            arrayResult[j] = inverted[i];
            j++;
        }
        return arrayResult;
    }
}
