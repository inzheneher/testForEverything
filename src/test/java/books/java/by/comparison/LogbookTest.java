package books.java.by.comparison;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.util.List;

public class LogbookTest {

    @Test
    @DisplayName("Catch exception and fail test")
    public void readLogbook() throws IOException {
        Logbook logbook = new Logbook();

        List<String> entries = logbook.readAllEntries();

        Assertions.assertEquals(3, entries.size());
    }

    @Test
    @DisplayName("Catch exception and fail pass")
    public void readLogbookFail() {
        Logbook logbook = new Logbook();

        Executable when = () -> logbook.readAllEntries();

        Assertions.assertThrows(IOException.class, when);
    }
}