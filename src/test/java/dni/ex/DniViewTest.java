package dni.ex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class DniViewTest {
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out; 
        System.setOut(new PrintStream(outputStream));
    }
    @Test
    void testAskNumberDni_valid() {
        
        String simulatedInput = "12345678\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));      
       
        int dniNumber = DniView.askNumberDni();    
        
        assertThat(dniNumber, is(12345678));    
        
        String output = outputStream.toString().trim();
        String expectedOutput = "------------ Calculate Letter DNI ------------\nEnter the DNI number:"; 
        assertThat(output, is(expectedOutput));
    }

    @Test
    void testShowsLetterDni() {
        char letterDni = 'Z';
        int dni = 12345678;

        DniView.showsLetterDni(letterDni, dni);

        String output = outputStream.toString().trim();

        String expectedOutput = "--------------------------------\nThe DNI letter is: Z\nThe Full Identification number is: Z12345678";
        assertThat(output, is(expectedOutput));

        System.setOut(originalOut);

    }
}