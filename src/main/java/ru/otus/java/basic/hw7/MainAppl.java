package ru.otus.java.basic.hw7;

/**
 * Описание/Пошаговая инструкция выполнения домашнего задания:
 * Создайте класс Человек с полями name (имя) и currentTransport (текущий транспорт)
 * Реализуйте в вашем приложении классы Машина, Лошадь, Велосипед, Вездеход
 * Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
 * В приложении должны быть типы местности: густой лес, равнина, болото
 * Человек должен иметь возможность сесть на любой из этих видов транспорта, встать с него,
 * или переместиться на некоторое расстояние (при условии что он находится на каком-либо транспорте)
 * При попытке выполнить перемещение у человека, не использующего транспорт, считаем что он просто идет указанное расстояние пешком
 * При перемещении Машина и Вездеход тратят бензин, который у них ограничен. Лошадь тратит силы.
 * Велосипед может использоваться без ограничений (можете для усложнения велосипедом тратить силы “водителя”).
 * При выполнении действия результат должен быть отпечатан в консоль
 * У каждого вида транспорта есть местности по которым он не может перемещаться: машина - густой лес и болото,
 * лошадь и велосипед - болото, вездеход - нет ограничений
 * При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
 */
public class MainAppl {
    public static void main(String[] args) {
        Cross[] crosses = {
                new Cross(3, TerrainType.SWAMP),
                new Cross(50, TerrainType.PLAIN),
                new Cross(200, TerrainType.PLAIN),
                new Cross(20, TerrainType.FOREST)
        };

        Transport[] transpors = {
                new Bicycle("Гоночный", "Белый"),
                new Car("Rommster", "Черная", "Y007", 45f, 0.15f),
                new Horse("Стрела", "Рыжая", 250, 5),
                new Rover("Тактик", "Хаки", "888m", 60f, 0.2f)
        };
        Human[] travelers = new Human[]{
                new Human("Артем", transpors[0], 60, 6, 1),
                new Human("Анна", transpors[1], 50, 5, 3),
                new Human("Джек", null, 50, 2, 1),
                new Human("Робин", transpors[3], 50, 4, 2),
                new Human("Елена", transpors[2], 40, 2, 1)
        };

        for (Human traveler : travelers) {
            System.out.println();
            traveler.info();
            for (int i = 0; i < crosses.length; i++) {
                traveler.move(crosses[i]);
            }
        }
    }
}