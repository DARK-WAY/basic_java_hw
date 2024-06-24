package ru.otus.java.basic.hw14;

/**
 * Необходимо выполнить две реализации задачи заполнения массива
 * Реализация №1
 * <p>
 * Реализуйте метод, который создает double массив длиной 100_000_000 элементов
 * Метод должен должен циклом for пройти по каждому элементу и посчитать его значение по формуле:
 * array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
 * Засеките время выполнения цикла и выведите его в консоль.
 * Реализация №2:
 * <p>
 * Сделайте то же самое что и в реализации один, только чтобы массив заполняли 4 потока одновременно.
 * То есть первый поток заполняет первую четверть массива, второй - вторую и т.д.
 * И посмотрите насколько быстрее выполнится работа по сравнению с одним потоком.
 */
public class MyAppl {
    public static void main(String[] args) {
        int sizeArray = 100_000_000;
        try {
            long time = System.currentTimeMillis();
            initArrayOneThread(sizeArray);
            System.out.println("Время выполнения метода initArrayOneThread = " + (System.currentTimeMillis() - time));

            time = System.currentTimeMillis();
            initArrayFourThread(sizeArray);
            System.out.println("Время выполнения метода initArrayFourThread = " + (System.currentTimeMillis() - time));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private static void initArrayOneThread(int sizeArray) {

        double[] array = new double[sizeArray];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        //System.out.println("Поток = " + Thread.currentThread().getName());
    }

    private static void initArrayFourThread(int sizeArray) throws InterruptedException {
        double[] array = new double[sizeArray];
        double part = sizeArray / 4;
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < part; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
            System.out.println("Поток1 = " + Thread.currentThread().getName());
        });
        Thread thread2 = new Thread(() -> {
            for (int i = (int) part; i < part * 2; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
            System.out.println("Поток2 = " + Thread.currentThread().getName());
        });

        Thread thread3 = new Thread(() -> {
            for (int i = (int) part * 2; i < (int) part * 3; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
            System.out.println("Поток3 = " + Thread.currentThread().getName());
        });

        Thread thread4 = new Thread(() -> {
            for (int i = (int) part * 3; i < array.length; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
            System.out.println("Поток4 = " + Thread.currentThread().getName());
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

    }
}
