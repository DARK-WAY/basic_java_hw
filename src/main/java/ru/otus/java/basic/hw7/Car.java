package ru.otus.java.basic.hw7;

// Реализуйте в вашем приложении класс Машина.
// Машина тратит бензин, который у нее ограничен.
public class Car implements Transport {
    private final String model;                                 // модель
    private final String color;                                 // цвет
    private final String number;                                // номер
    private final float maxAmountFuel;                         //Максимальное кол-во топлива
    private float curAmountFuel;                                //Текущее кол-во топлива
    private final float fuelConsumption;                        // расход топлива.
    private final TransportType typeTransport = TransportType.CAR;

    public Car(String model, String color, String number, float maxAmountFuel, float fuelConsumption) {
        this.model = model;
        this.color = color;
        this.number = number;
        this.maxAmountFuel = maxAmountFuel;
        this.curAmountFuel = maxAmountFuel;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String getFullName() {
        return typeTransport.getName() + " " + model + " " + color + " " + number + ". Остаток топлива = " + curAmountFuel;
    }

    @Override
    public TransportType getTypeTransport() {
        return typeTransport;
    }

    //Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
    //не может перемещаться по густому лесу и болоту
    //При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
    @Override
    public boolean move(Cross cross) {
        TerrainType terrainType = cross.getTerrainType();
        float distance = cross.getDistance();

        if (terrainType == TerrainType.FOREST || terrainType == TerrainType.SWAMP) {
            System.out.println("На машине нельзя проехать по типу местности:" +
                    (terrainType == TerrainType.FOREST ? TerrainType.FOREST.getName() : TerrainType.SWAMP.getName()));
            return false;
        }
        if (curAmountFuel < fuelConsumption * distance) {
            System.out.println("На машине нельзя преодолеть дистанцию " + distance + " км: не достаточно топлива. Остаток топлива  = " + curAmountFuel);
            return false;
        }
        curAmountFuel -= fuelConsumption * distance;
        return true;
    }
}