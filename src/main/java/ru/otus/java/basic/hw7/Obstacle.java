package ru.otus.java.basic.hw7;

public interface Obstacle {
    TerrainType getTerrainType();

    float getDistance();

    default void overcomeObstacles(Human traveler) {
        Transport transport = traveler.getCurrentTransport();
        boolean isOvercome;
        if (transport == null) {
            isOvercome = traveler.move(this);
        } else {
            isOvercome = transport.move(this, traveler);
        }

        if (!isOvercome) {
            System.out.println(traveler.getName() + " сошел(-ла) с дистанции.");
        }
    }

}
