package ru.otus.java.basic.hw7;

public enum TerrainType {
    // в приложении должны быть типы местности: густой лес, равнина, болото
    FOREST("Густой лес"),
    PLAIN("Равнина"),
    SWAMP("Болото");
    private String name;

    TerrainType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
