package multiThreading.joinTesting;

public class Program2 {
    public static void main(String[] args) {
        NewThread newThread = new NewThread();
        Thread thread = new Thread(newThread, "Дочерний поток");
        thread.start();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Takt: " + i + " потока " + Thread.currentThread().getName());
                thread.join();
//                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
