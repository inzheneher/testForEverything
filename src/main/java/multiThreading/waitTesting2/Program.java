package multiThreading.waitTesting2;

public class Program {
    public static void main(String[] args) {
        Store store = new Store();
        new Thread(new Producer(store)).start();
        new Thread(new Consumer(store)).start();
    }
}
