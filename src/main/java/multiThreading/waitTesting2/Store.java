package multiThreading.waitTesting2;

public class Store {

    private int goodsNumber;
    private boolean trigger;

    public int getGoodsNumber() {
        return goodsNumber;
    }

    synchronized void get() {
        while (!trigger)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        trigger = false;
        goodsNumber--;
        System.out.println("Товар забран со склада. Товаров на складе: " + goodsNumber);
        notify();
    }

    synchronized void put() {
        while (trigger)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        trigger = true;
        goodsNumber++;
        System.out.println("Товар помещён на склад. Товаров на складе: " + goodsNumber);
        notify();
    }
}
