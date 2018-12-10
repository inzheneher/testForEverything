package interfaces;

public class MultipleImplementationTest implements A, B {

    private String name;
    private Integer age;

    public MultipleImplementationTest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public <I> void printParameter(I a) {
        System.out.println(a.toString());
    }

    @Override
    public <I> void returnToConsole(I a) {
        System.out.println("Return " + a.toString());
    }

    @Override
    public <I> void deleteFromConsole(I a) {
        System.out.println("Delete " + a.toString());
    }

    public static void main(String[] args) {
        A testA = new MultipleImplementationTest("Ivan", 35);
        B testB = new MultipleImplementationTest("Petr", 40);
        testA.printParameter(testA);
        testB.printParameter(testB);
        testA.deleteFromConsole(testB);
        testB.returnToConsole(testA);
    }

    @Override
    public String toString() {
        return "MultipleImplementationTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
