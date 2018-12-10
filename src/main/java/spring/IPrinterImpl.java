package spring;

public class IPrinterImpl implements IPrinter {
    public void printNewText(String s) {
        System.out.println("New text is: " + s);
    }
}
