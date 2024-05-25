package ru.otus.java.basic.hw7;

public class Horse implements Transport {
    private final String name;              // кличка
    private final String color;            // цвет
    private final float enduranceMax;      // выносливость
    private float enduranceCurrent;       // остаток сил, которые можно потратить
    private final float expenses;         // затраты сил при передвижении
    private final TransportType typeTransport = TransportType.HORSE;

    public Horse(String name, String color, float enduranceMax, float expenses) {
        this.name = name;
        this.color = color;
        this.enduranceMax = enduranceMax;
        this.enduranceCurrent = enduranceMax;
        this.expenses = expenses;
    }

    @Override
    public String getFullName() {
        return "Лошадь по кличке " + name + " " + color + ". Остаток сил = " + enduranceCurrent;
    }

    @Override
    public TransportType getTypeTransport() {
        return typeTransport;
    }

    //Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
    //не может перемещаться по болоту
    //При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
    @Override
    public boolean move(Cross cross) {
        TerrainType terrainType = cross.getTerrainType();
        float distance = cross.getDistance();

        if (terrainType == TerrainType.SWAMP) {
            System.out.println("На лошади нельзя нельзя проехать по типу местности: " + TerrainType.SWAMP.getName());
            return false;
        }
        if (enduranceCurrent < expenses * distance) {
            System.out.println("На лошади нельзя преодолеть дистанцию " + distance + " км: не достаточно сил у лошади. Остаток единиц выносливости у животного = " + enduranceCurrent);
            return false;
        }
        enduranceCurrent -= expenses * distance;
        return true;
    }
}
