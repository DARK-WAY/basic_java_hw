package ru.otus.java.basic.hw27;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
        int lastIdx = 0;
        int curIdx = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(nameFile))) {
            String str;
            while ((str = in.readLine()) != null) {
                lastIdx = str.indexOf(fragment, curIdx);
                while (lastIdx > 0) {
                    counter++;
                    curIdx = lastIdx + fragment.length();
                    lastIdx = str.indexOf(fragment, curIdx);
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return counter;
    }
}
