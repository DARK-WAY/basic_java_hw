package ru.otus.java.basic.hw5.animal;

public class Cat extends Animal {

    public Cat(String name, int runSpeed, int runChangeEndurance, int endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.runChangeEndurance = runChangeEndurance;
        this.swimSpeed = 0;
        this.swimChangeEndurance = 0;
        this.endurance = endurance;
    }

    @Override
    public int swim(int distance) {
        System.out.println(name + " не умеет плавать, не надо мучать животное.");
        return -1;
    }
}
