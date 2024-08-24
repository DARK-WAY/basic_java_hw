package src.main.java.ru.otus.java.basic.hw6;

public class Plate {

    private final int maxAmountFood;      //максимальное количество еды
    private int curAmountFood;      // текущее количество еды

    public int getCurAmountFood() {
        return curAmountFood;
    }
    public int getMaxAmountFood() {
        return maxAmountFood;
    }

    //При создании тарелки указывается ее объем и она полностью заполняется едой
    public Plate(int maxAmountFood) {
        this.maxAmountFood = maxAmountFood;
        this.curAmountFood = maxAmountFood;
    }

    //В тарелке должен быть метод, позволяющий добавить еду в тарелку.
    // После добавления в тарелке не может оказаться еды больше максимума
    public void addFood(int amountFood) {

        if (maxAmountFood >= curAmountFood + amountFood) {
            curAmountFood += amountFood;
            System.out.println("Еда увеличилась на " + amountFood + " единиц.");
        } else {
            System.out.println("В тарелку столько еды не помещается. Можно положить еще " + (maxAmountFood - amountFood) + "еды.");
        }
    }
    //В тарелке должен быть boolean метод уменьшения количества еды,
    // при этом после такого уменьшения, в тарелке не может оказаться отрицательное количество еды
    // (если удалось уменьшить еду так, чтобы в тарелке осталось >= 0 кусков еды,
    // то возвращаем true, в противном случае - false).
    public boolean reduceFood(int amountFood) {
        if (curAmountFood - amountFood >= 0) {
            curAmountFood -= amountFood;
            return true;
        }
        return false;
    }


}
