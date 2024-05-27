package ru.otus.java.basic.hw9;

import java.util.*;

public class MainAppl {
    public static void main(String[] args) {

        /*
         *  ------------------------- Часть 1  -------------------------------------
         *    1. Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList
         *    с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
         *    2. Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы,
         *    значение которых больше 5, и возвращающий сумму;
         *    3. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
         *    метод должен переписать каждую заполненную ячейку списка указанным числом;
         *    4. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
         *    увеличивающий каждый элемент списка на указанное число;
         */
        System.out.println("\nЗадание 1");
        System.out.println(initList(5, 20));

        System.out.println("\nЗадание 2");
        List<Integer> intList1 = new LinkedList<>(Arrays.asList(1, 23, -5, -15));
        System.out.println(intList1);
        System.out.println("Сумма элементов LinkedList = " + sumList(intList1));

        System.out.println("\nЗадание 3");
        List<Integer> intList2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("intList2:" + intList2);
        initListValue(0, intList2);
        System.out.println("intList2:" + intList2);

        System.out.println("\nЗадание 4");
        List<Integer> intList3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("intList2:" + intList3);
        initListIncreaseValue(10, intList3);
        System.out.println("intList2:" + intList3);

        /*
         * ----------------------------- Часть 2 --------------------------------
         * Создайте класс Сотрудник с полями: имя, возраст;
         *  5. Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
         *  6. Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст,
         *  и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
         *  7. Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и проверяющий,
         *  что средний возраст сотрудников превышает указанный аргумент;
         *  8. Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника.
         */
        System.out.println("\nЧасть 2");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Иванов Иван Иванович", 35));
        employees.add(new Employee("Петров Семен Маркович", 28));
        employees.add(new Employee("Сидорова Мирия Антоновна", 55));
        employees.add(new Employee("Крючкова Надежда Васильевна", 28));
        for (Employee listEmpl : employees) {
            System.out.println(listEmpl.getName() + " - " + listEmpl.getAge() + "; ");
        }

        System.out.println("\nЗадание 5");
        System.out.println("Имена сотрудников: " + getNamesEmployees(employees));

        System.out.println("\nЗадание 6");
        int age = 35;
        System.out.println("Сотрудники старше " + (age - 1) + " лет : ");
        for (Employee listEmployees : getEmployeesAgeValue(employees, age)) {
            System.out.println(listEmployees.getName() + " - " + listEmployees.getAge());
        }
        System.out.println("\nЗадание 7");
        float minAverageAge = 39.33f;
        if (averageAgeCompare(employees, minAverageAge)) {
            System.out.println("Cредний возраст сотрудников превышает " + minAverageAge + " лет (года).");
        } else {
            System.out.println("Cредний возраст сотрудников не превышает " + minAverageAge + " лет.");
        }

        System.out.println("\nЗадание 8");
        System.out.println("Список самых юных сотрудников: ");
        for (Employee listEmployees : youngestEmployee(employees)) {
            System.out.println(listEmployees.getName() + " - " + listEmployees.getAge());
        }
    }

    /**
     * 8. Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника.
     * Несколько сотрудников может быть самых молодых
     */
    public static List<Employee> youngestEmployee(List<Employee> employees) {
        List<Employee> listYoungest = new ArrayList<>();
        int minAge = employees.get(0).getAge();
        listYoungest.add(employees.get(0));

        for (int i = 1; i < employees.size(); i++) {
            if (employees.get(i).getAge() < minAge) {
                listYoungest.clear();
            }
            if (employees.get(i).getAge() <= minAge) {
                listYoungest.add(employees.get(i));
                minAge = employees.get(i).getAge();
            }
        }
        return listYoungest;
    }

    /**
     * 7. Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и проверяющий,
     * что средний возраст сотрудников превышает указанный аргумент;
     */

    public static boolean averageAgeCompare(List<Employee> employees, float minAverageAge) {
        float factAverageAge, sumAge = 0f;

        for (Employee e : employees) {
            sumAge += (float) e.getAge();
        }
        factAverageAge = sumAge / (float) employees.size();
        return factAverageAge > minAverageAge;
    }

    /**
     * 6. Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст,
     * и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
     */
    public static List<Employee> getEmployeesAgeValue(List<Employee> employees, int age) {
        List<Employee> listEmployees = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getAge() >= age) {
                listEmployees.add(e);
            }
        }
        return listEmployees;
    }

    /**
     * 5. Реализуйте метод, принимающий в качестве аргумента список сотрудников и возвращающий список их имен;
     */
    public static List<String> getNamesEmployees(List<Employee> employees) {
        List<String> listEmployeeNames = new ArrayList<>();
        for (Employee employee : employees) {
            listEmployeeNames.add(employee.getName());
        }
        return listEmployeeNames;
    }

    /**
     * 4. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, увеличивающий каждый элемент списка на указанное число;
     */
    public static void initListIncreaseValue(int value, List<Integer> intList) {
        int size = intList.size();
        for (int i = 0; i < size; i++) {
            intList.set(i, intList.get(i) + value);
        }
    }

    /**
     * 3. Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
     * метод должен переписать каждую заполненную ячейку списка указанным числом;
     */

    public static void initListValue(int value, List<Integer> intList) {
        int size = intList.size();
        for (int i = 0; i < size; i++) {
            intList.set(i, value);
        }
    }

    /**
     * 2. Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы,
     * значение которых больше 5, и возвращающий сумму;
     */

    public static int sumList(List<Integer> intList) {
        int sum = 0;
        for (Integer elem : intList) {
            if (elem > 5) {
                sum += elem;
            }
        }
        return sum;
    }

    /**
     * 1. Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList
     * с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
     */

    public static List<Integer> initList(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("Указаны не корректные входные данные.");
        }
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <= max - min; i++) {
            arrayList.add(min + i);
        }
        return arrayList;
    }
}
