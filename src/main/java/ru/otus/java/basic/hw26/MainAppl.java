package ru.otus.java.basic.hw26;

public class MainAppl {
    public static void main(String[] args) {

        Apple apple = new Apple(200);
        Orange orange = new Orange(200);

        Box<Fruit> fruitBox1 = new Box();
        Box<Fruit> fruitBox2 = new Box();
        Box<Apple> appleBox = new Box();
        Box<Orange> orangeBox = new Box();

        System.out.println("fruitBox1:" + fruitBox1.info());
        System.out.println("fruitBox2:" + fruitBox2.info());
        System.out.println("appleBox:" + appleBox.info());
        System.out.println("orangeBox:" +orangeBox.info());

        System.out.println();

        fruitBox1.add(apple);
        fruitBox1.add(orange);
        fruitBox2.add(apple);
        //appleBox.add(apple);
        orangeBox.add(orange);

        System.out.println("fruitBox1:" + fruitBox1.info());
        System.out.println("fruitBox2:" + fruitBox2.info());
        System.out.println("appleBox:" + appleBox.info());
        System.out.println("orangeBox:" +orangeBox.info());

        System.out.println();

        System.out.println("Вес коробки1 с фруктами = " + fruitBox1.weight() + " грамм.");
        System.out.println("Вес коробки2 с фруктами = " + fruitBox2.weight() + " грамм.");
        System.out.println("Вес коробки с яблоками = " + appleBox.weight() + " грамм.");
        System.out.println("Вес коробки с апельсинами = " + orangeBox.weight() + " грамм.");

        System.out.println();

        System.out.println(fruitBox1.compare(appleBox) ? "Вес коробки1 с фруктами равен весу коробки с яблоками" : "Вес коробки1 с фруктами НЕ равен весу коробки с яблоками");
        System.out.println(orangeBox.compare(fruitBox2) ? "Вес коробки с апельсинами равен весу коробки2 с фруктами" : "Вес коробки с апельсинами НЕ равен весу коробки2 с фруктами");

        System.out.println();

        orangeBox.moveToBox(fruitBox1);
        fruitBox1.moveToBox(fruitBox2);
    
        System.out.println("fruitBox1:" + fruitBox1.info());
        System.out.println("fruitBox2:" + fruitBox2.info());
        System.out.println("appleBox:" + appleBox.info());
        System.out.println("orangeBox:" +orangeBox.info());

        System.out.println();

    }
}
