package DataTests;
import Data.DigitalSignature;
import Data.Nif;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DigitalSignatureTest {

    @Test
    public void TestingConstructorNull () {
        Exception exception = assertThrows( IllegalArgumentException.class, () -> {
            DigitalSignature digitalSignature = new DigitalSignature(null);
        });

        String expectedMessage = "No se ha introducido ninguna firma.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void TestingEquals () {
        byte[] test = new byte[10];
        DigitalSignature dg1 = new DigitalSignature (test);
        DigitalSignature dg2 = new DigitalSignature (test);
        assertTrue(dg1.equals(dg2));
    }
}
