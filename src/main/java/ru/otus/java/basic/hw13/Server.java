package ru.otus.java.basic.hw13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Сервер стартанул.");
        ServerSocket serverSocket = new ServerSocket(8555);
        Socket socket = serverSocket.accept();
        System.out.println("Клиент подключился.");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("Доступны следующие математические операции: +,-,*,/ .");

        // Ждем задание + его выполняем
        String result;
        Float parametr1 = Float.parseFloat(in.readUTF());
        System.out.println(parametr1);

        String operation = in.readUTF();
        System.out.println(operation);

        Float parametr2 = Float.parseFloat(in.readUTF());
        System.out.println(parametr2);

        System.out.println("Сервер получил задание.");

        switch (operation) {
            case "+":
                result = String.valueOf(parametr1 + parametr2);
                break;
            case "-":
                result = String.valueOf(parametr1 - parametr2);
                break;
            case "/":
                if (parametr2 != 0f) {
                    result = String.valueOf(parametr1 / parametr2);
                } else {
                    result = "Деление  на 0 -  запрещено";
                }
                break;
            case "*":
                result = String.valueOf(parametr1 * parametr2);
                break;
            default:
                result = "Не кеорректный математический знак: " + operation;
                break;
        }

        out.writeUTF(result);
        System.out.println("Сервер отправилд результат.");

        System.out.println("Сервер отключается.");
        socket.close();
        serverSocket.close();
    }
}
