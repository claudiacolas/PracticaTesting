package UnifiedPlatformTests;

import Data.*;
import Exceptions.NotValidPINException;
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
    public void initialize() {
        unifiedPlatform = new UnifiedPlatform();
        this.pin = new SmallCode("123");
    }

    @Test
    public void testingPinEnteredSuccess() throws NotValidPINException, ConnectException {
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

}
