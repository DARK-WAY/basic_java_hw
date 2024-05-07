package ru.otus.java.basic.hw1;

import java.util.Scanner;

public class MainAppHomeWork {
    public static void main(String[] args) {
        //(*) При запуске приложения, запросите у пользователя число от 1 до 5, и после ввода выполнения метод, соответствующий указанному номеру со случайным значением аргументов;
        Scanner scanner = new Scanner(System.in);
        int noJob;

        System.out.println("Введите номер задания от 1 до 5:");
        do {
            noJob = scanner.nextInt();
            if (noJob < 1 || noJob > 5) {
                System.out.println("Введен номер задания = " + noJob + ". Попробуйте еще раз.\nВведите номер задания от 1 до 5 ");
            }
        } while (noJob < 1 || noJob > 5);

        if (noJob == 1) {
            System.out.println("\nЗадание 1");
            greetings();

        } else if (noJob == 2) {
            System.out.println("\nЗадание 2");
            int a = (int) (Math.random() * 21) - 10, b = (int) (Math.random() * 21) - 10, c = (int) (Math.random() * 21) - 10;

            /*int a = (int) (Math.random() * 10), b = (int) (Math.random() * 10), c = (int) (Math.random() * 10);
            // определим знак
            if ((int) (Math.random() * 2) > 0) {
                a = -1 * a;
            }
            if ((int) (Math.random() * 2) > 0) {
                b = -1 * b;
            }
            if ((int) (Math.random() * 2) > 0) {
                c = -1 * c;
            }*/

            System.out.println("Определены значения: a = " + a + ", b = " + b + ", c = " + c);
            checkSign(a, b, c);
            /*int a = 10, b = 20, c = 32;
            checkSign(a, b, c);
            a = -30;
            b = a;
            c = 50;
            checkSign(a, b, c);*/
        } else if (noJob == 3) {
            System.out.println("\nЗадание 3");
            selectColor();
        } else if (noJob == 4) {
            System.out.println("\nЗадание 4");
            compareNumbers();
        } else {
            System.out.println("\nЗадание 5");
            addOrSubtractAndPrint((int) (Math.random() * 10), (int) (Math.random() * 10), Math.random() > 0.5);
            //addOrSubtractAndPrint((int) (Math.random() * 10), (int) (Math.random() * 10), false);
        }

    }

    public static void greetings() {
        //(1) Реализуйте метод greetings(), который при вызове должен отпечатать в столбец 4 слова: Hello, World, from, Java;
        System.out.println("Hello\nWord\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        /* (2) Реализуйте метод checkSign(..), принимающий в качестве аргументов 3 int переменные a, b и c.
         * Метод должен посчитать их сумму, и если она больше или равна 0, то вывести в консоль сообщение “Сумма положительная”,
         * в противном случае - “Сумма отрицательная”;
         */
        if ((a + b + c) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        /*(3) Реализуйте метод selectColor() в теле которого задайте int переменную data с любым начальным значением.
         * Если data меньше 10 включительно, то в консоль должно быть выведено сообщение “Красный”,
         * если от 10 до 20 включительно, то “Желтый”, если больше 20 - “Зеленый”
         */
        int data = (int) (Math.random() * 100);
        System.out.println("data = " + data);
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 20) {
            System.out.println("Зеленый");
        } else {
            System.out.println("Желтый");
        }

    }

    public static void compareNumbers() {
        /*(4) Реализуйте метод compareNumbers(), в теле которого объявите две int переменные a и b с любыми начальными значениями.
         * Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
         */
        int a = (int) (Math.random() * 100), b = (int) (Math.random() * 100);
        System.out.println("Определены значения: a = " + a + ", b = " + b);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        /*(5) Создайте метод addOrSubtractAndPrint(int initValue, int delta, boolean increment).
         *     Если increment = true, то метод должен к initValue прибавить delta и отпечатать в консоль результат, в противном случае - вычесть;
         */
        System.out.println("initValue = " + initValue + ", delta = " + delta + ", increment = " + increment);
        System.out.println(increment ? (initValue + delta) : (initValue - delta));
    }

}
