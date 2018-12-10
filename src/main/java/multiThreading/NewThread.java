package multiThreading;

public class NewThread implements Runnable {

    NewThread() {
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        System.out.println("Secondary thread start");
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Tic " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Secondary thread stop");
    }
}
