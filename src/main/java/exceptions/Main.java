package exceptions;

public class Main {

    private static void method() throws ChildOne {
        throw new ChildOne();
    }

    private static void method2() {
        throw new ChildTwo();
    }

    public static void main(String[] args) throws ChildOne {
        Main.method();
    }
}
