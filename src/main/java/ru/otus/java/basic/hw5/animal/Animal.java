package ru.otus.java.basic.hw5.animal;

public class Animal {
    String name;         //имя
    int runSpeed;   //скорость бега
    int runChangeEndurance; // затраты выносливости при беге
    int swimSpeed;  // скорость плавания
    int swimChangeEndurance; // затраты выносливости при плавании
    int endurance = 0;      //выносливость (измеряется в условных единицах)

    public Animal() {}

    public Animal(String name, int runSpeed, int runChangeEndurance, int swimSpeed, int swimChangeEndurance, int endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.runChangeEndurance = runChangeEndurance;
        this.swimSpeed = swimSpeed;
        this.swimChangeEndurance = swimChangeEndurance;
        this.endurance = endurance;
    }

    public int run(int distance) {
        //Все животные на 1 метр бега тратят 1 ед выносливости
        //distance = расстояние  в метрах
        if (distance == 0) {
            System.out.println(name + " не пробежал(-а) дистанцию = " + distance + ", так как не сказали куда бежать ");
            return 0;
        }
        int enduranceCalc = (int) Math.ceil((double) distance * (double) runChangeEndurance);
        if (endurance < enduranceCalc || endurance == 0) {
            System.out.println(name + " не пробежал(-а) дистанцию = " + distance + ", у животного появилось состояние усталости. ");
            endurance = 0;
            return -1;
        }
        endurance -= enduranceCalc;
        int time = (int) Math.ceil((double) distance / (double) runSpeed);
        System.out.println(name + " пробежал(-а) дистанцию = " + distance + " за " + time + " секунд");
        return time;
    }

    public int swim(int distance) {
        // Затраты выносливости: Собаки на 1 метр плавания - 2 ед.
        // Лошади на 1 метр плавания тратят 4 единицы
        // Кот плавать не умеет
        //distance = расстояние  в метрах

        if (distance == 0) {
            System.out.println(name + " не проплыл(-а) дистанцию = " + distance + ", так как не сказали куда плыть. ");
            return 0;
        }
        int enduranceCalc = (int) Math.ceil((double) distance * (double) swimChangeEndurance);
        if (endurance < enduranceCalc || endurance == 0) {
            System.out.println(name + " не проплыл(-а) дистанцию = " + distance + ", у животного появилось состояние усталости. ");
            endurance = 0;
            return -1;
        }
        endurance -= enduranceCalc;
        int time = (int) Math.ceil((double) distance / (double) swimSpeed);
        System.out.println(name + " проплыл(-а) дистанцию = " + distance + " за " + time + " секунд");
        return time;

    }

    public void info() {
        System.out.println("Состояние животного по кличке " + name + " = " + endurance);
    }
}

