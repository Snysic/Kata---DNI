package dni.ex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DniControllerTest {

    private ByteArrayOutputStream outputStream; 
    private PrintStream originalOut; 
    private ByteArrayInputStream inputStream; 

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream(); 
        originalOut = System.out; 
        System.setOut(new PrintStream(outputStream)); 
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(System.in); 
    }

    @Test
    void testStartProgram_validInput() {
        String simulatedInput = "12345678\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
    
        DniController.startProgram();
    
        String output = outputStream.toString().trim();
    
        System.out.println("Actual output:\n" + output);
    
        String expectedOutput = """
                ------------ Calculate Letter DNI ------------
                Enter the DNI number:
                --------------------------------
                The DNI letter is: Z
                The Full Identification number is: Z12345678
                """;
    
        assertEquals(expectedOutput, output);
    }

    @Test
    void testStartProgram_invalidInputThenValid() {
        String simulatedInput = "invalid\n12345678\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream); 

        DniController.startProgram();

        String output = outputStream.toString().trim();

        String expectedOutput = """
            ------------ Calculate Letter DNI ------------
            Enter the DNI number:
            Invalid input. Please enter a valid DNI number.
            ------------ Calculate Letter DNI ------------
            Enter the DNI number:
            --------------------------------
            The DNI letter is: Z
            The Full Identification number is: Z12345678
            """;

        assertThat(output, is(expectedOutput));
    }

    @Test
void testShowsLetterDni() {
    char letter = 'Z';
    int dniNumber = 12345678;

    DniController.showsLetterDni(letter, dniNumber);

    String output = outputStream.toString().trim();

    String expectedOutput = 
            "--------------------------------\n" +
            "The DNI letter is: Z\n" +
            "The Full Identification number is: Z12345678";

    assertEquals(expectedOutput, output);
}
}