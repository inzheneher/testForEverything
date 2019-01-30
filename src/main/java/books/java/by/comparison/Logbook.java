package books.java.by.comparison;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Logbook {

    private List<String> entries;

    public Logbook() {
        entries = Arrays.asList("Tuk", "Tak", "Bardak");
    }

    public List<String> readAllEntries() throws IOException {
        throw new IOException();
//        return entries;
    }
}
