package DataTests;
import Data.SmallCode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmallCodeTest {
    @Test
    public void TestingConstructorNull () {
        Exception exception = assertThrows( IllegalArgumentException.class, () -> {
            SmallCode smallCode = new SmallCode (null);
        });

        String expectedMessage = "No se ha introducido ningún código.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void TestingConstructorWrongObject () {
        Exception exception = assertThrows( IllegalArgumentException.class, () -> {
            SmallCode smallCode = new SmallCode ("1234");
        });

        String expectedMessage = "No se ha introducido el código correctamente.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void TestingEquals () {
        SmallCode sm1 = new SmallCode ("123");
        SmallCode sm2 = new SmallCode ("123");
        assertTrue(sm1.equals(sm2));
    }
}
