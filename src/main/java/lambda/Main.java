package lambda;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    static int a = 10;
    static int b = 90;

    public static void main(String[] args) {
        int c = 220;
        Mathematical<Integer> operationSum = (x, y) -> x + y;
        Mathematical<String> operationConcatination = (s1, s2) -> s1 + " " + s2;
        Printable print = System.out::println;
        Mathematical<Person> abraCodabra =
                (j, h) ->
                        new Person(
                                j.getAge() + h.getAge(), j.getHeight() + h.getHeight()
                        );
        Mathematical<Integer> variables = (x, y) -> {
            a = 100;
            return a + c;
        };
        Mathematical<Double> divideByZero = (x, y) -> {
            if (y == 0) return 0d;
            return x / y;
        };

        Person person = new Person(25, 170);
        Personable personable = person::getHeight;

        BinaryOperator<Double> binaryOperator = Math::pow;

        UnaryOperator<String> stringConverter = s -> s + " " + s;

        Function<Integer, String> function = i -> i + "UU!";

        System.out.println(operationSum.compute(45, 18));
        System.out.println(operationConcatination.compute("Hello", "World"));
        print.print("Hi there, mthfckr");
        System.out.println(abraCodabra.compute(new Person(18, 180), new Person(36, 185)));
        System.out.println(a);
        System.out.println(variables.compute(a, b));
        System.out.println(a);
        System.out.println(divideByZero.compute(19d, 0d));
        System.out.println(divideByZero.compute(19d, 13d));
        System.out.println(personSurgeon(person::getAge));
        System.out.println(personSurgeon(personable));
        System.out.println(new BigDecimal(binaryOperator.apply(100d, 100d)).toPlainString());
        System.out.println(stringConverter.apply("Hello"));
        System.out.println(function.apply(8));
    }

    private static int personSurgeon(@NotNull Personable person) {
        return person.personAge();
    }
}
