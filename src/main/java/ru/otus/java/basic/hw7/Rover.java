package ru.otus.java.basic.hw7;

//Реализуйте в вашем приложении класс Вездеход
// Вездеход тратит бензин, который у нее ограничен.
public class Rover implements Transport {
    private final String model;                               // модель
    private final String color;                               // цвет
    private final String number;                              // номер
    private final float maxAmountFuel;                         //Максимальное кол-во топлива
    private float curAmountFuel;                         //Текущее кол-во топлива
    private final float fuelConsumption;                        // расход топлива.

    public Rover(String model, String color, String number, float maxAmountFuel, float fuelConsumption) {
        this.model = model;
        this.color = color;
        this.number = number;
        this.maxAmountFuel = maxAmountFuel;
        this.curAmountFuel = maxAmountFuel;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String getFullName() {
        return "Вездеход " + model + " " + color + " " + number;
    }

    //Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
    //При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
    @Override
    public boolean move(Obstacle obstacle, Human human) {
        TerrainType terrainType = obstacle.getTerrainType();
        float distance = obstacle.getDistance();

        if (curAmountFuel < fuelConsumption * distance) {
            System.out.println(human.getName() + " на вездеходе не может преодолеть дистанцию " + distance + " км: не достаточно топлива. Остаток топлива  = " + curAmountFuel);
            return false;
        }
        curAmountFuel -= fuelConsumption * distance;
        System.out.println(human.getName() + " на вездеходе проехал(-а) " + distance + " км по местности: " + terrainType.getName() + ". Остаток топлива  = " + curAmountFuel);
        return true;
    }
}
