package ru.otus.java.basic.hw28;

public class MyAppl {
    static final Object mon = new Object();
    static char lastSymbol = 'C';
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> printSymbol('A'));
        Thread thread2 = new Thread(() -> printSymbol('B'));
        Thread thread3 = new Thread(() -> printSymbol('C'));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

    }
    public static void printSymbol(char symbol){
        synchronized (mon){
            try {
                for (int i = 0; i < 5; i++) {
                    while (symbol== 'A' && lastSymbol != 'C' || symbol== 'B' && lastSymbol != 'A' ||  symbol== 'C' && lastSymbol != 'B') {
                        mon.wait();
                    }
                    System.out.print(symbol);
                    lastSymbol= symbol;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
