package lambda;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteCallable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        try (Ignite ignite = Ignition.start("example-ignite.xml")) {

            Collection<String> list = Arrays.asList("Ivan", "Bober", "Tucha");
            Collection<IgniteCallable<Integer>> stringList = new ArrayList<>();

            for (final String word:
                 list) {
                stringList.add(word::length);
            }

            Collection<Integer> result = ignite.compute().call(stringList);

            int sum = result.stream().mapToInt(Integer::intValue).sum();

            System.out.println(sum);

        }


    }
}
