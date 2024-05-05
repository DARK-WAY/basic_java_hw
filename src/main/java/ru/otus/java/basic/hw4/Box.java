package ru.otus.java.basic.hw4;

public class Box {
    private String color;
    private int width;
    private int height;
    private int depth;
    private boolean isOpened = false; // считаем, что при создании коробка закрыта
    private boolean empty = true;// считаем, что при создании коробка пуста

//  ----------  конструкторы ---------------------
    public Box(String color, int width, int height, int depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
//  --------------- getter-ы  -------------------
    public String getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public boolean isEmpty() {
        return empty;
    }

//  --------------- setter-ы  -------------------
    //    Коробку можно перекрашивать.
    public void setColor(String color) {
        this.color = color;
    }
// -----------------  МЕТОДЫ  ---------------------
   // Коробку можно открывать и закрывать.
   public void open() {
       if (isOpened) {
           System.out.println("Коробка уже открыта");
       } else {
           System.out.println("Коробка открыта");
           isOpened = true;
       }
   }
    public void close() {
        if (!isOpened) {
            System.out.println("Коробка уже закрыта");
        } else {
            System.out.println("Коробка закрыта");
            isOpened = false;
        }
    }

    //    У коробки должен быть метод, печатающий информацию о ней в консоль.
    public void info() {
        String statusBox = "Закрыта";
        if (this.isOpened) {
            statusBox = "Открыта";
        }

        if (this.empty){
            statusBox += ", пустая .";
        }
        else {
            statusBox += ", заполнена.";
        }

        System.out.println("Коробка: ширина= " + this.width + ", высота= " + this.height + ", глубина= " +
                this.depth + ", цвет коробки = " + this.color + ", состояние = " + statusBox );
    }

//    В коробку можно складывать предмет (если в ней нет предмета), или выкидывать его оттуда (только если предмет в ней есть),
//    только при условии, что коробка открыта (предметом читаем просто строку).
    public void inPut() {
        //В коробку можно складывать предмет
        if (this.empty && this.isOpened) {
            this.empty = false;
            System.out.println("В коробку положили предмет.");
        } else {
            System.out.print("Нельзя положить предмет. ");
            if (!this.empty) System.out.print("Коробка уже заполнена.");
            if (!this.isOpened) System.out.println("Коробка закрыта.");
        }

    }
    public void outPut() {
        //Из коробки можно выкидывать предмет (только если предмет в ней есть)
        if (!this.empty && this.isOpened) {
            this.empty = true;
            System.out.println("Коробка стала пустой.");
        } else {
            System.out.print("Из коробки нельзя что-то выкинуть. ");
            if (this.empty) System.out.print("Коробка пустая.");
            if (!this.isOpened) System.out.println("Коробка закрыта.");
        }

    }


}
    /*
        2
        Попробуйте реализовать класс по его описания: объекты класса Коробка должны иметь размеры и цвет.
        Коробку можно открывать и закрывать. Коробку можно перекрашивать.
        Изменить размер коробки после создания нельзя.
        У коробки должен быть метод, печатающий информацию о ней в консоль.
        В коробку можно складывать предмет (если в ней нет предмета), или выкидывать его оттуда (только если предмет в ней есть),
        только при условии что коробка открыта (предметом читаем просто строку).
        Выполнение методов должно сопровождаться выводом сообщений в консоль.

     */