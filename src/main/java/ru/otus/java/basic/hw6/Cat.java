package ru.otus.java.basic.hw6;

public class Cat {
    private final String name;        //имя
    private final int appetite;       //аппетит

    private boolean fullness = false;   // сытость, когда создаем котов, они голодны.

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFullness() {
        return fullness;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    //Если коту удалось покушать (хватило еды), сытость = true
    //Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
    // то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
    public void toEat(Plate plate) {
        if (fullness ){
            System.out.println("Котик сыт.");
            return;
        }
        if (plate.reduceFood(appetite)){
            fullness = true;
            System.out.println(name + " хорошо покушал(-а).");
        }
        else {
            fullness = false;
            System.out.println("В тарелке мало еды.");
        }
    }
}
