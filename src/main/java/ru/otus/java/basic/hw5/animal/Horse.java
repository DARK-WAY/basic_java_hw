package ru.otus.java.basic.hw5.animal;
public class Horse extends Animal {
    String type; //  Лошадь, Жеребец, Жеребенок
    public Horse (String name, int runSpeed, int runChangeEndurance, int swimSpeed, int swimChangeEndurance, int endurance, String type) {
        super(name, runSpeed, runChangeEndurance, swimSpeed, swimChangeEndurance, endurance);
        this.type = type;
    }

    @Override
    public void info(){
        System.out.println(type + " по кличке " + name +  ". Состояние = "  + endurance);
    }

}