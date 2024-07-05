package ru.otus.java.basic.hw13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8555);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        System.out.println(in.readUTF());

        System.out.println("ВВедите пример для вычисления по формату: [Аргумент1] [знак математической операции] [Аргумент1].");
        Scanner scanner = new Scanner(System.in);
        String task = scanner.nextLine();

        for (String parameter : taskForCalculatorIn(task)) {
            out.writeUTF(parameter);
        }

        System.out.println(task + " = " + in.readUTF());
        System.out.println("Клиент отключается");
        socket.close();

    }

    private static String[] taskForCalculatorIn(String task) {
        String[] parameters = new String[3];
        // разобьем полученную строку на 2 аргумента и математический оператор
        // будем считать, что пользователь ввел корректные данные для простоты, иначе придется накручивать логику по проверке.

        for (int i = 0; i < task.length(); i++) {
            if (task.charAt(i) == '+' || task.charAt(i) == '-' || task.charAt(i) == '*' || task.charAt(i) == '/') {
                parameters[0] = task.substring(0, i);
                parameters[1] = task.substring(i, i + 1);
                parameters[2] = task.substring(i + 1);
            }
        }
        System.out.println("argument1 = " + parameters[0] + ", argument2 = " + parameters[2] + ", знак = " + parameters[1]);
        return parameters;
    }
}
