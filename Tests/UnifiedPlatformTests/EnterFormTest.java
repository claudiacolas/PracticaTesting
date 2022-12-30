package UnifiedPlatformTests;

import CitizenManagementPlatform.UnifiedPlatform;
import Data.Goal;
import Data.Nif;
import DoubleTestClasses.GPDDouble;
import DoubleTestClasses.GPDExceptionDouble;
import Exceptions.*;
import PublicAdministration.CardPayment;
import PublicAdministration.Citizen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class EnterFormTest {

    private UnifiedPlatform unifiedPlatform;
    private Citizen citizen;
    private Goal goal;
    private CardPayment cardPayment;
    private Nif nif;

    @BeforeEach
    public void initialize() {
        unifiedPlatform = new UnifiedPlatform();
        this.nif = new Nif("12345678A");
        this.citizen = new Citizen(nif, "Montse", "address", "666666666");
        this.cardPayment = new CardPayment("123", nif, new Date(), new BigDecimal("56.89"));
        this.goal = Goal.PUBLICWORKERS;
    }

    @Test
    public void testingFormEnteredSuccess() throws IncompleteFormException, IncorrectVerificationException, ConnectException {
        unifiedPlatform.setGpd(new GPDDouble());
        unifiedPlatform.setCardPayment(cardPayment);
        unifiedPlatform.enterForm(citizen, goal);
        assertEquals(this.citizen.toString(), unifiedPlatform.getPersData());
        assertEquals(this.goal.toString(), unifiedPlatform.getGoal());
    }

    @Test
    public void testingIncompleteFormException () {
        Exception exception = assertThrows(IncompleteFormException.class, () -> {
            unifiedPlatform.enterForm(null, null); });
        String expectedMessage = "Campos de información vacíos en el formulario.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testingIncorrectVerificationException() {
        unifiedPlatform.setGpd(new GPDExceptionDouble());
        Exception exception = assertThrows(IncorrectVerificationException.class, () -> {
            unifiedPlatform.enterForm(citizen, goal); });
        String expectedMessage = "La verificación no se ha realizado con éxito.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
