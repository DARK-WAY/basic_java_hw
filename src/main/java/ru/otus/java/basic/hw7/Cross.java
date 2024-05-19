package ru.otus.java.basic.hw7;

public class Cross implements Obstacle {
    private final float distance;       // Дистанция
    private final TerrainType terrainType; // Тип местности

    public Cross(int distance, TerrainType terrainType) {
        this.distance = distance;
        this.terrainType = terrainType;
    }

    @Override
    public float getDistance() {
        return distance;
    }

    @Override
    public TerrainType getTerrainType() {
        return terrainType;
    }


}
