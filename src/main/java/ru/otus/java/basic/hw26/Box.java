package ru.otus.java.basic.hw26;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();


    public String info() {
        return fruits.isEmpty() ? "Коробка пустая." : "В коробке лежат " + fruits.toString();
    }

    public void add(T value) {
        fruits.add(value);
    }

    public int weight() {
        int weightFruits = 0;
        for (int i = 0; i < fruits.size(); i++) {
            weightFruits += fruits.get(0).getWeight();
        }
        return weightFruits;
    }

    public boolean compare(Box<?> another) {
        return this.weight() == another.weight();
    }

    public boolean moveToBox(Box<? super Fruit > toBox) {
        if (fruits.isEmpty()) return false;

        for (T fruit : fruits) {
            toBox.add(fruit);
        }
        fruits.clear();
        return true;

    }
}
