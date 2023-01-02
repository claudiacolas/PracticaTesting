package UnifiedPlatformTests;

import CitizenManagementPlatform.UnifiedPlatform;
import Data.Nif;
import Data.SmallCode;
import DoubleTestClasses.CASDouble;
import DoubleTestClasses.CASExceptionDouble;
import DoubleTestClasses.CertificationAuthorityExceptionDouble;
import Exceptions.*;
import Exceptions.NotValidPINException;
import PublicAdministration.CardPayment;
import PublicAdministration.CreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class EnterCardDataTest {

    private UnifiedPlatform unifiedPlatform;
    private CreditCard credC;
    private Nif nif;
    private CardPayment cardPayment;
    private BigDecimal imp;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        unifiedPlatform = new UnifiedPlatform();
        this.nif = new Nif("12345678A");
        this.credC = new CreditCard(nif, "123", new Date(), new SmallCode("333"), 3000);
        this.cardPayment = new CardPayment("123", nif, new Date(), this.imp);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testingCardDataSuccess() throws NotValidPaymentDataException, IncompleteFormException, InsufficientBalanceException, ConnectException, ProceduralException {
        unifiedPlatform.setCas(new CASDouble());
        unifiedPlatform.setCardPayment(cardPayment);
        unifiedPlatform.setImport(new BigDecimal(3.86));
        unifiedPlatform.enterCardData(credC);
        assertEquals("OPERATION ACCEPTED. Below you can get your certificate", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testingIncompleteFormException() {
        unifiedPlatform.setCas(new CASDouble());
        Exception exception = assertThrows(IncompleteFormException.class, () -> {
            unifiedPlatform.enterCardData(null); });
        String expectedMessage = "Campos de información vacíos en el formulario.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testingNotValidPaymentDataException() {
        unifiedPlatform.setCas(new CASExceptionDouble());
        unifiedPlatform.setCardPayment(cardPayment);
        Exception exception = assertThrows(NotValidPaymentDataException.class, () -> {
            unifiedPlatform.enterCardData(credC); });
        String expectedMessage = "El pago no se ha realizado con éxito.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testingInsufficientBalanceException() {
        unifiedPlatform.setCas(new CASDouble());
        unifiedPlatform.setImport(new BigDecimal(3.86));
        this.credC = new CreditCard(nif, "123", new Date(), new SmallCode("333"), 2);
        unifiedPlatform.setCardPayment(new CardPayment("ref", nif, new Date(), this.imp));
        Exception exception = assertThrows(InsufficientBalanceException.class, () -> {
            unifiedPlatform.enterCardData(credC); });
        String expectedMessage = "Balance insuficente.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}