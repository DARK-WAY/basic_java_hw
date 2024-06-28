package ru.otus.java.basic.hw12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Описание/Пошаговая инструкция выполнения домашнего задания:
 * Реализуйте приложение, позволяющее работать с текстовыми файлами
 * При старте приложения, в консоль выводится список текстовых файлов из корневого каталоге проекта
 * Далее программа запрашивает имя файла, с которым хочет работать пользователь
 * Содержимое файла выводится в консоль
 * Затем любую введенную пользователем строку необходимо записывать в указанный файл
 */
public class MainAppl {
    public static void main(String[] args) {
        String directoryPath = System.getProperty("user.dir");
        outputListFilesDirectory(directoryPath);
        printFileToConsole(directoryPath);
        writeFromConsoleToFile();
    }

    /**
     * Затем любую введенную пользователем строку необходимо записывать в указанный файл
     */
    private static void writeFromConsoleToFile() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст для  сохранения в файл");
        String textFile = scanner.nextLine();
        System.out.println("Ввели текст '" + "\u001B[31m" + textFile + "'" + "\u001b[0m");


        System.out.println("Введите имя файла куда хотите  сохранить введенный  текст ");
        String nameFile = scanner.next();
        System.out.println("Ввели имя файла '" + "\u001B[31m" + nameFile + "'" + "\u001b[0m");

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(nameFile))) {
            byte[] buffer = textFile.getBytes(StandardCharsets.UTF_8);
            out.write(buffer);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Далее программа запрашивает имя файла, с которым хочет работать пользователь
     * * Содержимое файла выводится в консоль
     */
    private static void printFileToConsole(String directoryPath) {
        boolean fileFind = false;
        System.out.println("Введите имя файла из полученного списка в директории " + directoryPath);
        Scanner scanner = new Scanner(System.in);
        String nameFile = scanner.next();
        System.out.println("Ввели имя файла '" + nameFile + "' из директории " + directoryPath);

        File directory = new File(directoryPath);
        String[] filesList = directory.list();

        if( filesList != null) {
            for (String s : filesList) {
                if (s.equals(nameFile)) {
                    try (InputStreamReader in = new InputStreamReader(new BufferedInputStream(new FileInputStream(nameFile)), StandardCharsets.UTF_8)) {
                        int r = in.read();
                        while (r != -1) {
                            System.out.print((char) r);
                            r = in.read();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fileFind = true;
                    System.out.println();
                    break;
                }
            }
        }
        if ((filesList == null) || (filesList.length == 0) || !fileFind) {
            System.out.println("Заданного файла '" + nameFile + "' не существует в директории " + directoryPath);
        }
    }

    /**
     * При старте приложения, в консоль выводится список текстовых файлов из корневого каталога проекта
     */
    private static void outputListFilesDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        System.out.println(directory);
        if (directory.isDirectory()) {
            File[] filesList = directory.listFiles();
            if (filesList != null) {
                for (File s : filesList) {
                    if (s.isFile()) {
                        System.out.println(s.getName());
                    }
                }
            } else {
                System.out.println("Ошибка получения содержимого в директории " + directoryPath);
            }
        } else {
            System.out.println("Ошибка указания директории");
        }
    }
}
