package ru.otus.java.basic.hw7;


public class Cross {
    private final float distance;       // Дистанция
    private final TerrainType terrainType; // Тип местности

    public Cross(int distance, TerrainType terrainType) {
        this.distance = distance;
        this.terrainType = terrainType;
    }

    public float getDistance() {
        return distance;
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }
}
