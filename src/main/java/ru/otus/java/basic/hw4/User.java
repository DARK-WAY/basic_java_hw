package ru.otus.java.basic.hw4;

public class User {
    private String lastName;
    private String firstName;
    private String middleName;
    private int yearBirth;
    private String email;

    public User(String lastName, String firstName, String middleName, int yearBirth, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.yearBirth = yearBirth;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public String getEmail() {
        return email;
    }

    public void info(){
        System.out.println("ФИО: " + lastName + " " + firstName + " " + middleName  + "\nГод рождения: " +  yearBirth + "\nemail: " + email );
    }
}


  /*Создайте класс Пользователь (User) с полями: фамилия, имя, отчество, год рождения, email;
        1Реализуйте у класса конструктор, позволяющий заполнять эти поля при создании объекта;
        2В классе Пользователь реализуйте метод, выводящий в консоль информацию о пользователе в виде:
        ФИО: фамилия имя отчество
        Год рождения: год рождения
        e-mail: email

        В методе main() Main класса создайте массив из 10 пользователей и заполните его объектами и
        с помощью цикла выведите информацию только о пользователях старше 40 лет.



        Попробуйте реализовать класс по его описания: объекты класса Коробка должны иметь размеры и цвет.
        Коробку можно открывать и закрывать. Коробку можно перекрашивать.
        Изменить размер коробки после создания нельзя.
        У коробки должен быть метод, печатающий информацию о ней в консоль.
        В коробку можно складывать предмет (если в ней нет предмета), или выкидывать его оттуда (только если предмет в ней есть),
        только при условии что коробка открыта (предметом читаем просто строку).
        Выполнение методов должно сопровождаться выводом сообщений в консоль.

     */
