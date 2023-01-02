package UnifiedPlatformTests;

import Data.*;
import Exceptions.NotValidPINException;
import Exceptions.ProceduralException;
import Services.CertificationAuthority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import PublicAdministration.*;
import DoubleTestClasses.*;
import CitizenManagementPlatform.*;

import java.net.ConnectException;

import static org.junit.jupiter.api.Assertions.*;

public class EnterPINTest {
    private UnifiedPlatform unifiedPlatform;

    private Nif nif;
    private SmallCode pin;

    @BeforeEach
    public void setUp() {
        unifiedPlatform = new UnifiedPlatform();
        this.pin = new SmallCode("123");
        unifiedPlatform.setPreviousStepConfirmed(true);
    }

    @Test
    public void testingPinEnteredSuccess() throws NotValidPINException, ConnectException, ProceduralException {
        unifiedPlatform.setCertificationAuthority(new CertificationAuthorityDouble());
        unifiedPlatform.enterPIN(pin);
        assertEquals(this.pin.toString(), unifiedPlatform.getPin());
    }

    @Test
    public void testingNotValidPINException () {
        unifiedPlatform.setCertificationAuthority(new CertificationAuthorityExceptionDouble());
        Exception exception = assertThrows(NotValidPINException.class, () -> { unifiedPlatform.enterPIN(pin); });
        String expectedMessage = "El PIN introducido no es incorrecto.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testingPreviousStepConfirmed () {
        unifiedPlatform.setPreviousStepConfirmed(false);
        Exception exception = assertThrows(ProceduralException.class, () -> { unifiedPlatform.enterPIN(pin); });
        String expectedMessage = "El paso anterior no se ha completado con éxito.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
