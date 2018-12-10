package multiThreading.waitTesting;

public class Consumer implements Runnable {
    private Store store;

    Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            store.get();
        }
    }
}
