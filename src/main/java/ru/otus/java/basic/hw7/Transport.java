package ru.otus.java.basic.hw7;


public interface Transport { // маршрут
    String getFullName(); // наименование транспорта

    TransportType getTypeTransport();   // тип транспорта

    boolean move(Cross cross); // передвижение по выбранной трассе
}