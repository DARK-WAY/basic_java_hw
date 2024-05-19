package ru.otus.java.basic.hw7;
//Создайте класс Человек с полями name (имя) и currentTransport (текущий транспорт)
//Человек должен иметь возможность сесть на любой из этих видов транспорта, встать с него,
//или переместиться на некоторое расстояние (при условии, что он находится на каком-либо транспорте).
//При попытке выполнить перемещение у человека, не использующего транспорт, считаем что он просто идет указанное расстояние пешком

public class Human {
    private final String name;                // имя
    private Transport currentTransport;    // текущий транспорт

    private final float enduranceMax;     // выносливость
    private float enduranceCurrent;       // остаток сил, которые можно потратить
    private final float expensesWalki;    // затраты сил при хождении пешком  * 10
    private final float expensesBicycle;  // затраты сил при передвижении на велосипеде

    public Human(String name, Transport currentTransport, float enduranceMax, float expensesWalki, float expensesBicycle) {
        this.name = name;
        this.currentTransport = currentTransport;
        this.enduranceMax = enduranceMax;
        this.enduranceCurrent = enduranceMax;
        this.expensesWalki = expensesWalki;
        this.expensesBicycle = expensesBicycle;
    }

    public String getName() {
        return name;
    }

    public float getEnduranceCurrent() {
        return enduranceCurrent;
    }

    public float getExpensesBicycle() {
        return expensesBicycle;
    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }

    public void setEnduranceCurrent(float enduranceCurrent) {
        this.enduranceCurrent = enduranceCurrent;
    }

    //Человек должен иметь возможность сесть на любой из этих видов транспорта, встать с него
    // если приходит NULL, то считаем, что человек встал с транспорта ( если был на транспорте ) и теперь будет передвигаться пешком.
    // если пришел новый транспорт - считаем, что человек пересел на новое транспортное средство
    // в классе человека передвижение пешком
    public boolean move(Obstacle obstacle) {
        TerrainType terrainType = obstacle.getTerrainType();
        float distance = obstacle.getDistance();
        if (currentTransport == null) {
            if (enduranceCurrent < expensesWalki * distance) {
                System.out.println(name + " не может преодолеть дистанцию " + distance + " км: не достаточно сил. Остаток единиц выносливости = " + enduranceCurrent);
                return false;
            }
            enduranceCurrent -= expensesWalki * distance;
            System.out.println(name + " прошел(-а) " + obstacle.getDistance() + " км по местности: " + terrainType.getName());
            return true;
        }
        System.out.println(name + " не может дистанцию пройти  пешком, так как использует транспорт.");
        return false;

    }

    // информация
    public void info() {
        if (currentTransport == null) {
            System.out.println(name + " без транспорта.");
        } else {
            System.out.println(name + ", его(ее) транспорт: " + currentTransport.getFullName());
        }
    }

}
