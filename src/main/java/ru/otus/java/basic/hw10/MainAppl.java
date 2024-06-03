package ru.otus.java.basic.hw10;

/**
 * Домашнее задание.
 * Реализуйте класс PhoneBook, который хранит в себе список имен (фио) и телефонных номеров;
 * Метод add() должен позволять добавлять запись имя-телефон;
 * Метод find() выполнять поиск номер(-а, -ов) телефона по имени;
 * Под одним именем может быть несколько телефонов (в случае однофамильцев, или наличии у одного человека нескольких номеров),
 * тогда при запросе такой фамилии должны выводиться все телефоны;
 * Метод containsPhoneNumber должен проверять наличие телефона в справочнике.
 */

public class MainAppl {
    public static void main(String[] args) {
        Contact contact1 = new Contact("Иванов Иван Иванович");
        Contact contact2 = new Contact("Петров Сергей Михайлович");
        Contact contact3 = new Contact("Сидорова Ольга Викторовна");
        contact1.addTelephone("111-12-12");
        contact1.addTelephone("115-01-22");
        contact2.addTelephone("222-45-54");

        contact1.info();
        contact2.info();
        contact3.info();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(contact1);
        phoneBook.add(contact2);
        phoneBook.add(contact3);
        System.out.println(phoneBook.find("Иванов Иван Иванович"));
        System.out.println(phoneBook.find("Петров Сергей Михайлович"));
        System.out.println(phoneBook.find("Сидорова Ольга Викторовна"));
        System.out.println(phoneBook.find("Эрнст Неизвестный"));

        System.out.println("Телефон 111-12-12:" + (phoneBook.containsPhoneNumber( "111-12-12")?"есть в телефонном справочнике.":"нет в телефонном справочнике."));
        System.out.println("Телефон 989-98-98:" + (phoneBook.containsPhoneNumber( "989-98-98")?"есть в телефонном справочнике.":"нет в телефонном справочнике."));

    }
}
