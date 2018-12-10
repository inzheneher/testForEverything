package multiThreading;

public class Main {
    public static void main(String[] args) {
        new NewThread();
        System.out.println("Primary thread start");
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Tac " + i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Primary thread stop");
    }
}
