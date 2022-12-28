package DataTests;
import Data.Nif;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NifTest {
    @Test
    public void TestingConstructorNull () {
        Exception exception = assertThrows( IllegalArgumentException.class, () -> {
            Nif nif = new Nif (null);
        });

        String expectedMessage = "No se ha introducido ningún código.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void TestingConstructorWrongObject () {
        Exception exception = assertThrows( IllegalArgumentException.class, () -> {
            Nif nif = new Nif ("código incorrecto");
        });

        String expectedMessage = "No se ha introducido el NIF correctamente.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void TestingToString () {
        Nif nif = new Nif ("12345678A");
        String nifString = "Nif{nif ciudadano='12345678A'}";
        assertEquals(nif.toString(), nifString);
    }

    @Test
    public void TestingEquals () {
        Nif nif1 = new Nif ("12345678A");
        Nif nif2 = new Nif ("12345678A");
        assertTrue(nif1.equals(nif2));
    }
}
