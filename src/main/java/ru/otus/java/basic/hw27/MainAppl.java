package ru.otus.java.basic.hw27;

import java.io.*;
import java.util.Scanner;

public class MainAppl {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла");
        String nameFile = scanner.next();

        System.out.println("Введите фрагмент файла");
        String fragment = scanner.next();

        System.out.println("Фрагмент " + fragment + " в файле " + nameFile + " встречается " + numberOfMatches(fragment, nameFile) + " раз(а).");
    }

    private static int numberOfMatches(String fragment, String nameFile) {
        int counter = 0;
        int lastIdx;
        int curIdx = 0;
        StringBuilder strFull= new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(nameFile))) {
            String str;
            while ((str = in.readLine()) != null) {
                strFull.append(str);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        lastIdx = strFull.indexOf(fragment, curIdx);
        while (lastIdx > 0) {
            counter++;
            curIdx = lastIdx + fragment.length();
            lastIdx = strFull.indexOf(fragment, curIdx);
        }
        return counter;
    }
}
