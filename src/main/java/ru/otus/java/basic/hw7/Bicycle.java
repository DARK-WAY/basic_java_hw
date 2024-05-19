package ru.otus.java.basic.hw7;


public class Bicycle implements Transport {
    private final String model;                               // модель
    private final String color;                               // цвет

    public Bicycle(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public String getFullName() {
        return "Велосипед " + model + " " + color;
    }

    //Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
    //не может перемещаться по болоту
    //При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
    @Override
    public boolean move(Obstacle obstacle, Human human) {
        TerrainType terrainType = obstacle.getTerrainType();
        float distance = obstacle.getDistance();
        float enduranceCurrent = human.getEnduranceCurrent(); // остаток сил, которые можно потратить
        float expensesBicycle = human.getExpensesBicycle();   // затраты сил при передвижении на велосипеде

        if (terrainType == TerrainType.SWAMP) {
            System.out.println(human.getName() + " на машине не может преодолеть дистанцию " + distance + " км: нельзя проехать по типу местности: " + TerrainType.SWAMP.getName());
            return false;
        }
        if (enduranceCurrent < expensesBicycle * distance) {
            System.out.println(human.getName() + " не может преодолеть дистанцию " + distance + " км: не достаточно сил. Остаток единиц выносливости = " + enduranceCurrent);
            return false;
        }
        enduranceCurrent -= expensesBicycle * distance;
        human.setEnduranceCurrent(enduranceCurrent);
        System.out.println(human.getName() + " на велосипеде преодолел(-а) дистанцию " + distance + " км по местности: " + terrainType.getName());
        return true;

    }
}
