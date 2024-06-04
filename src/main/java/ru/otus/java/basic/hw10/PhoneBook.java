package ru.otus.java.basic.hw10;

import java.util.*;

/**
 * Реализуйте класс PhoneBook, который хранит в себе список имен (фио) и телефонных номеров;
 * Метод add() должен позволять добавлять запись имя-телефон;
 * Метод find() выполнять поиск номер(-а, -ов) телефона по имени;
 * Под одним именем может быть несколько телефонов (в случае однофамильцев, или наличии у одного человека нескольких номеров),
 * тогда при запросе такой фамилии должны выводиться все телефоны;
 * Метод containsPhoneNumber должен проверять наличие телефона в справочнике.
 */
public class PhoneBook {

    private Map<String, Set<String>> contacts = new HashMap<>();

    public void add(Contact contact) {
        contacts.put(contact.getFio(), contact.getTelephone());
    }

    public Set<String> find(String fio) {
        return contacts.get(fio);

    }
    public boolean containsPhoneNumber(String telephone) {
        for (Map.Entry<String, Set<String>> e : contacts.entrySet()) {
            if (e.getValue().contains(telephone)) {
                return true;
            }
        }
        return false;
    }
}
