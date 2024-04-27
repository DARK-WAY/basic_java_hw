package ru.otus.java.basic.hw2;

import java.util.Arrays;

public class MainAppHomeWork {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        printStringConsole(3, "Home work 2");

        System.out.println("\nЗадание 2");
        sumArray(new int[]{1, 6, 44, 4});

        System.out.println("\nЗадание 3");
        int[] arr = new int[10];
        initArray(2, arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("\nЗадание 4");
        increaseElementArray(1, arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("\nЗадание 5");
        comparingPartsArray(new int[]{1, 6, 4, 4, 5, -4, 2, 6});

        System.out.println("\nЗадание 6");
        arraysSum(new int[]{1, 25, 3, 7, 65}, new int[]{0, 5, 7}, new int[]{9, 0, 0, -2, -35, 6, 8, 10});

        System.out.println("\nЗадание 7");
        findPoint(new int[]{1, 2, 3, 3, 2, 1});
        findPoint(new int[]{9, 4});
        findPoint(new int[]{4, -2, 4});
        findPoint(new int[]{5, 3, 4, -2});

        System.out.println("\nЗадание 8");
        int[] array = new int[]{1, 5, 2, 6, 7};
        System.out.println(Arrays.toString(array));
        boolean isAscendingOrder = true; // true -  в порядке  возрастания / false -  в порядке убывания
        isArraySorted(array, isAscendingOrder);

        int[] array2 = new int[]{ 8, 5, 3, 0, -2};
        System.out.println(Arrays.toString(array2));
        boolean isAscendingOrder2 = false; // true -  в порядке  возрастания / false -  в порядке убывания
        isArraySorted(array2, isAscendingOrder2);

        System.out.println("\nЗадание 9");
        int[] arrOver = {1, 10, 3, 5 };
        System.out.print( Arrays.toString(arrOver) + " -> ");
        flipOver(arrOver);


    }


    public static void printStringConsole(int n, String str) {
        //1. Реализуйте метод, принимающий в качестве аргументов целое число и строку, и печатающий в консоль строку указанное количество раз
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    public static void sumArray(int[] arr) {
        // 2. Реализуйте метод, принимающий в качестве аргумента целочисленный массив, суммирующий все элементы,
        // значение которых больше 5, и печатающий полученную сумму в консоль;
        int sum = 0;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                sum += arr[i];
            }
        }
        System.out.println("sum = " + sum);
    }

    public static void initArray(int n, int[] arr) {
        // 3. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
        // метод должен заполнить каждую ячейку массива указанным числом;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n;
        }
    }

    public static void increaseElementArray(int n, int[] arr) {
        // 4. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
        // увеличивающий каждый элемент массива на указанное число;
        for (int i = 0; i < arr.length; i++) {
            arr[i] += n;
        }
    }

    public static void comparingPartsArray(int[] arr) {
        // 5. Реализуйте метод, принимающий в качестве аргумента целочисленный массив, и печатающий в консоль информацию о том,
        // сумма элементов какой из половин массива больше;
        System.out.println(Arrays.toString(arr));
        if (arr.length == 1) {
            System.out.println("Масси из 1 элемента:" + arr[0]);
        } else {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < arr.length / 2; i++) {
                sum1 += arr[i];
            }
            for (int i = arr.length / 2; i < arr.length; i++) {
                sum2 += arr[i];
            }
            if (sum1 == sum2) {
                System.out.println("Сумма элеменетов каждой половины одинаковая и равна " + sum1);
            } else {
                System.out.println(sum1 > sum2 ? ("Сумма элеменетов больше 1 половины = " + sum1) : ("Сумма элементов больше 2 половины = " + sum2));
            }
        }
    }

    public static void arraysSum(int[] a, int[] b, int[] c) {
//        6. Реализуйте метод, принимающий на вход набор целочисленных массивов, и получающий новый
//        массив равный сумме входящих;
//        Пример: { 1, 2, 3 }  + { 2, 2 } + { 1, 1, 1, 1, 1 } = { 4, 5, 4, 1, 1 }
        int aLen = a.length, bLen = b.length, cLen = c.length;

        //определяем длиун массивов и ищем самый длинный
        int maxI = aLen;
        if (maxI < Math.max(bLen, cLen)) {
            maxI = Math.max(bLen, cLen);
        }
        int[] array = new int[maxI];
        // организовываем цикл по самому большому массиву
        for (int i = 0; i < array.length; i++) {
            if (aLen > i) {
                array[i] += a[i];
            }
            if (bLen > i) {
                array[i] += b[i];
            }
            if (cLen > i) {
                array[i] += c[i];
            }
        }
        System.out.println("Сложили следующие массивы");
        System.out.println(Arrays.toString(a) + " + ");
        System.out.println(Arrays.toString(b) + " + ");
        System.out.println(Arrays.toString(c) + "  = ");
        System.out.println(Arrays.toString(array));


    }

    public static void findPoint(int[] array) {
        // 7. Реализуйте метод, проверяющий, что есть “точка” в массиве, в которой сумма левой и правой части равны. “Точка находится между элементами”;
        // Пример: { 1, 1, 1, 1, 1, | 5 }, { 5, | 3, 4, -2 }, { 7, 2, 2, 2 }, { 9, 4 }
        int sumLeft = array[0], sumRigth = array[array.length - 1];
        int iL = 0, iR = array.length - 1;
        System.out.println(Arrays.toString(array));
        //System.out.println("sumLeft = " + sumLeft + " sumRigth = " + sumRigth + "/ iL = " + iL + " iR = " + iR);

        while ((iL != iR) && (iR - iL) != 1) {
            if (sumLeft < sumRigth) {
                iL++;
                sumLeft += array[iL];
            } else if (sumLeft > sumRigth) {
                iR--;
                sumRigth += array[iR];
            } else {
                if ((iR - iL) == 2) { // осталось одно значение между индексами
                    iL++;
                    sumLeft += array[iL];
                } else {
                    iL++;
                    iR--;
                    sumLeft += array[iL];
                    sumRigth += array[iR];
                }
            }
            // System.out.println("sumLeft = " + sumLeft + " sumRigth = " + sumRigth + "/ iL = " + iL + "  iR = " + iR);
        }
        if (sumLeft == sumRigth) {
            System.out.println("Точка находится между элементами " + iL + " и " + iR);
        } else {
            System.out.print("Нет <точки>");
        }

    }

    private static void isArraySorted(int[] array, boolean isAscendingOrder) {
        //8. Реализуйте метод, проверяющий, что все элементы массива идут в порядке убывания или возрастания (по выбору пользователя)
        boolean isSorted = false;
        for (int i = 0; i < array.length - 1; i++) {
            if ((isAscendingOrder && array[i] < array[i + 1]) || (!isAscendingOrder && array[i] > array[i + 1])) {
                isSorted = true;
            } else {
                isSorted = false;
                break;
            }
        }
        if (isSorted) {
            System.out.println("все элементы массива идут в порядке " + (isAscendingOrder ? "возрастания" : "убывания"));
        } else {
            System.out.println("Элементы массива не отсортиваны");
        }
    }

    public static void flipOver(int[] array) {
    //  9  Реализуйте метод, “переворачивающий” входящий массив
    //    Пример: { 1 2 3 4 } => { 4 3 2 1 }
        int exch;
        for (int i = 0; i < array.length / 2; i++) {
            exch = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = exch;
        }
        System.out.println(Arrays.toString(array));
    }
}
