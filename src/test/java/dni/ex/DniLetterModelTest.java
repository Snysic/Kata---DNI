package dni.ex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class DniLetterModelTest {
    @Test
    void testCalculateLetterDni() {
        DniModel numberDni = new DniModel(99999998);


        char expectedResult = DniLetterModel.calculateLetterDni(numberDni);

        assertThat(expectedResult,is('T'));

    }
}