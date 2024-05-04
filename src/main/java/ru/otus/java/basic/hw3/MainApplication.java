package ru.otus.java.basic.hw3;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        int[][] array = new int[][]{{1, 7, 7}, {-5, -12, 20}};
        System.out.println(sumOfPositiveElements(array));

        System.out.println("\nЗадача 2");
        printSquareStars(5);

        System.out.println("\nЗадача 3");
        int[][] arrayInt = new int[5][5];
        initArrayInt(arrayInt, 1);
        System.out.println("Массив до зануления");
        printArray(arrayInt);
        initDiagonal(arrayInt);
        System.out.println("Массив после зануления");
        printArray(arrayInt);


        System.out.println("\nЗадача 4");
        printArray(array);
        System.out.println("Максимальное значение массива = " + findMax(array));

        System.out.println("\nЗадача 5");
        //int[][] arr = new int[][]{{1, 2, 3, 4}, {}, {4, 6, 7}};
        //int[][] arr = new int[][]{{1, 2, 3, 4}};
        int[][] arr = new int[][]{{}, {1, 2, 6}};
        printArray(arr);
        int sumSecondLine = sumSecondRow(arr);
        if (sumSecondLine > 0) {
            System.out.println("Сумма второй строки = " + sumSecondLine);
        } else System.out.println("Вторая строка  не существует");
    }

    private static void initArrayInt(int[][] array, int value) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = value;
            }
        }
    }

    public static int sumOfPositiveElements(int[][] arr) {
//        Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив,
//        метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    public static void printSquareStars(int size) {
//    Реализовать метод, который принимает в качестве аргумента int size и
//    печатает в консоль квадрат из символов * со сторонами соответствующей длины;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }

    }

    public static void initDiagonal(int[][] in) {
//  Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив
//  и зануляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе);
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                if (i == j || i == in[i].length - 1 - j) {
                    in[i][j] = 0;
                }
            }
        }
    }

    public static void printArray(int[][] array) {
        // метод для печати массива в консоль
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int findMax(int[][] array) {
//   Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    public static int sumSecondRow(int[][] array) {
//  Реализуйте метод, который считает сумму элементов второй строки двумерного массива,
//  если второй строки не существует, то в качестве результата необходимо вернуть -1
// Под второй строкой будем подразумевать значения массива array[1][...]
        int sum = -1;
        if (array.length < 2) {
            return sum;
        }
        for (int i = 0; i < array[1].length; i++) {
            sum += array[1][i];
        }
        return sum;
    }
}


