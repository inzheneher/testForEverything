package singleton;

public class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleInstance();
        singleton1.str = "raz";
        Singleton singleton2 = Singleton.getSingleInstance();
        System.out.println(singleton2.str);
    }
}
