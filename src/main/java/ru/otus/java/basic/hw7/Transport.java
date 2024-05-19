package ru.otus.java.basic.hw7;

public interface Transport { // маршрут
    String getFullName(); // наименование транспорта

    boolean move(Obstacle obstacle, Human human); // передвижение
}