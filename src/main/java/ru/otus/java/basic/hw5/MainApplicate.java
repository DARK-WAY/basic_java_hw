package ru.otus.java.basic.hw5;

import ru.otus.java.basic.hw5.animal.Cat;
import ru.otus.java.basic.hw5.animal.Dog;
import ru.otus.java.basic.hw5.animal.Horse;

/*
Создайте классы Cat, Dog и Horse с наследованием от класса Animal
У каждого животного есть имя, скорость бега и плавания (м/с), и выносливость (измеряется в условных единицах)
Затраты выносливости:
Все животные на 1 метр бега тратят 1 ед выносливости,
Собаки на 1 метр плавания - 2 ед.
Лошади на 1 метр плавания тратят 4 единицы
Кот плавать не умеет.
Реализуйте методы run(int distance) и swim(int distance), которые должны возвращать время, затраченное на указанное действие, и “понижать выносливость” животного.
Если выносливости не хватает, то возвращаем время -1 и указываем что у животного появилось состояние усталости.
При выполнении действий пишем сообщения в консоль.
Добавляем метод info(), который выводит в консоль состояние животного.
*/
public class MainApplicate {
    public static void main(String[] args) {

        Cat cat = new Cat("Несси", 8, 1, 300);
        Dog doggy = new Dog("Тотошка", 10, 1, 1, 2, 350, "Щенок");
        Horse foal = new Horse("Хвостик", 20, 1, 2, 4, 400, "Жеребёнок");

        cat.info();
        cat.run(200);
        cat.info();
        cat.run(150);
        cat.info();
        cat.swim(20);

        System.out.println();

        doggy.info();
        doggy.run(300);
        doggy.info();
        doggy.swim(150);
        doggy.info();

        System.out.println();

        foal.info();
        foal.run(300);
        foal.info();
        foal.swim(25);
        foal.info();
        foal.swim(10);
        foal.info();

    }


}
