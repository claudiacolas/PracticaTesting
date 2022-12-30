package DataTests;
import Data.DocPath;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DocPathTest {

    @Test
    public void TestingConstructorNull () {
        Exception exception = assertThrows( IllegalArgumentException.class, () -> {
            DocPath docPath = new DocPath(null);
        });

        String expectedMessage = "No se ha introducido ninguna ruta.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void TestingConstructorWrongObject () {
        Exception exception = assertThrows( IllegalArgumentException.class, () -> {
            DocPath docPath = new DocPath ("path");
        });

        String expectedMessage = "No se ha introducido la ruta correctamente.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void TestingEquals () {
        DocPath dp1 = new DocPath ("/Users");
        DocPath dp2 = new DocPath ("/Users");
        assertTrue(dp1.equals(dp2));
    }
}
