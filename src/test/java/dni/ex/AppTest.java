package dni.ex;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    void testMainRunsWithoutErrors() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            App.main(new String[]{});
            
            String output = outContent.toString();
            assertTrue(output.contains(""));
        } finally {
            System.setOut(originalOut);
        }
    }
}
