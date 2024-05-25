package ru.otus.java.basic.hw7;

public enum TransportType {

    CAR("Машина"),
    BICYCLE("Велосипед"),
    ROVER("Вездеход"),
    HORSE("Лошадь");

    private String name;

    TransportType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
