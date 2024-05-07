package ru.otus.java.basic.hw5.animal;

public class Dog extends Animal {
    String type; //  Собака, Песик, Щенок...
    public Dog (String name, int runSpeed, int runChangeEndurance, int swimSpeed, int swimChangeEndurance, int endurance, String type) {
        super(name, runSpeed, runChangeEndurance, swimSpeed, swimChangeEndurance, endurance);
        this.type = type;
    }

    @Override
    public void info(){
        System.out.println(type + " по кличке " + name +  ". Состояние = "  + endurance);
    }

}
