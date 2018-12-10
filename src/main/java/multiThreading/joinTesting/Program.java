package multiThreading.joinTesting;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        System.out.println(
                "Главный поток " +
                        Thread.currentThread().getName() +
                        " запущен: " +
                        Thread.currentThread().isAlive()
        );
        NewThread newThread = new NewThread();
        List<Thread> threadList = new ArrayList<>();
        Thread t1 = new Thread(newThread, "Potok1");
        Thread t2 = new Thread(newThread, "Potok2");
        Thread t3 = new Thread(newThread, "Potok3");
        threadList.add(t1);
        threadList.add(t2);
        threadList.add(t3);
        t1.start();
        t2.start();
        t3.start();
        getThreadCondition(threadList);
        try {
            System.out.println("Ожидание завершения потоков...");
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getThreadCondition(threadList);
        System.out.println(
                "Главный поток " +
                        Thread.currentThread().getName() +
                        " запущен: " +
                        Thread.currentThread().isAlive()
        );
    }

    private static void getThreadCondition(List<Thread> threadList) {
        for (Thread thread : threadList) {
            System.out.println("Поток " + thread.getName() + " запущен: " + thread.isAlive());
        }
    }
}
