package ru.otus.java.basic.hw7;

//Реализуйте в вашем приложении класс Лошадь
//Лошадь тратит силы
public class Horse implements Transport {
    private final String name;              // модель
    private final String color;            // цвет
    private final float enduranceMax;      // выносливость
    private float enduranceCurrent;       // остаток сил, которые можно потратить
    private final float expenses;         // затраты сил при передвижении

    public Horse(String name, String color, float enduranceMax, float expenses) {
        this.name = name;
        this.color = color;
        this.enduranceMax = enduranceMax;
        this.enduranceCurrent = enduranceMax;
        this.expenses = expenses;
    }

    @Override
    public String getFullName() {
        return "Лошадь по кличке " + name + " " + color;
    }

    //Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
    //не может перемещаться по болоту
    //При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
    @Override
    public boolean move(Obstacle obstacle, Human human) {
        TerrainType terrainType = obstacle.getTerrainType();
        float distance = obstacle.getDistance();

        if (terrainType == TerrainType.SWAMP) {
            System.out.println(human.getName() + " на лошади не может преодолеть дистанцию " + distance + " км: нельзя проехать по типу местности: " + TerrainType.SWAMP.getName());
            return false;
        }
        if (enduranceCurrent < expenses * distance) {
            System.out.println(human.getName() + " не может преодолеть дистанцию " + distance + " км: не достаточно сил у лошади. Остаток единиц выносливости = " + enduranceCurrent);
            return false;
        }
        enduranceCurrent -= expenses * distance;
        System.out.println(human.getName() + " на лошади преодолел(-а) дистанцию " + distance + " км по местности: " + terrainType.getName());
        return true;
    }
}
