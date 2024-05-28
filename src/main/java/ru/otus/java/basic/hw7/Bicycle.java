package ru.otus.java.basic.hw7;


public class Bicycle implements Transport {
    private final String model;                               // модель
    private final String color;                               // цвет
    private final TransportType typeTransport = TransportType.BICYCLE;

    public Bicycle(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public String getFullName() {
        return typeTransport.getName() + " " + model + " " + color;
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
            System.out.println("На велосипеде нельзя проехать по типу местности: " + TerrainType.SWAMP.getName());
            return false;
        }
        return true;
    }
}
