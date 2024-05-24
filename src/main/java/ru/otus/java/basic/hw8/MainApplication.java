package ru.otus.java.basic.hw8;

/**
 * Реализуйте метод, аргументом которого является двумерный строковый массив размером 4х4.
 * Если передан массив другого размера необходимо бросить исключение AppArraySizeException.
 * Метод должен обойти все элементы массива, преобразовать в int и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит текст вместо числа),
 * должно быть брошено исключение AppArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 * В методе main() необходимо вызвать полученный метод,
 * обработать возможные исключения AppArraySizeException и AppArrayDataException
 * и вывести результат расчета (сумму элементов, при условии, что подали на вход корректный массив).
*/
public class MainApplication {
    public static void main(String[] args) {
        String[][][] arr = {
                {
                        {"11", "12", "13", "14"},
                        {"21", "22", "23", "24"},
                        {"31", "32", "33", "34"},
                        {"41", "42", "43", "44"}
                },
                {
                        {"11", "12", "13"},
                        {"21", "22", "23", "24"},
                        {"31", "32", "33", "34"},
                        {"41", "42", "43", "44"}
                },
                {
                        {"11", "12", "13", "14"},
                        {"21", "22", "23", "24"},
                        {"31", "32", "33", "34"}
                },
                {
                        {"11", "12", "13", "14"},
                        {"21", "22", "23", "24"},
                        {"31", "Зима", "33", "34"},
                        {"41", "42", "43", "44"}
                }
        };
        for (int i = 0; i < arr.length; i++) {
            try {
                System.out.println("Сумма элементов arr[" + i + "] = " + sumArrayString(arr[i]));
            } catch (AppArrayDataException e) {
                System.out.println("Ошибка вычисления суммы элемента arr[" + i + "]. " + e.getMessage());
            } catch (AppArraySizeException e) {
                System.out.println("Ошибка вычисления суммы элемента arr[" + i + "]. " + e.getMessage());
            }
        }

    }

    public static int sumArrayString(String[][] arr) throws AppArrayDataException {
        int sum = 0;
        if (arr.length != 4) {
            throw new AppArraySizeException("Размер массива не равен 4х4 по строкам.");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new AppArraySizeException("Размер массива не равен 4х4 по столбцам");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);

                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Значение элемента массива [" + i + "][" + j + "]= '" + arr[i][j] + "' не корректное.");
                }
            }
        }
        return sum;
    }
}
