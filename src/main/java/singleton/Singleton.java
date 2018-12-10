package singleton;

public class Singleton {
    private static Singleton singleton;
    public String str;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
