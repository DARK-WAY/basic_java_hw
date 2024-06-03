package ru.otus.java.basic.hw10;

import java.util.HashSet;

public class Contact {
    private final String fio;
    private HashSet<String> telephone = new HashSet<>();

    public Contact(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public HashSet<String> getTelephone() {
        return telephone;
    }

    public void addTelephone(String telefon) {
        telephone.add(telefon);
    }

    public void info() {

        System.out.print("ФИО контакта: " + fio + ". Телефоны: ");
        for (String e : telephone) {
            System.out.print(e + "; ");
        }
        if (telephone.isEmpty()){
            System.out.print("Не предоставлены.");
        }
        System.out.println();
    }
}
