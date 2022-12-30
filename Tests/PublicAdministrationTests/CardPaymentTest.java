package PublicAdministrationTests;

import Data.Nif;
import PublicAdministration.CardPayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardPaymentTest {

    private String reference;
    private Nif nif;
    private BigDecimal imp;
    private Date date;
    private CardPayment cardPayment;

    @BeforeEach
    public void cardPaymentForTests() {
        this.reference = "123";
        this.nif = new Nif("47320966K");
        this.imp = new BigDecimal("56.89");
        this.date = new Date();
        this.cardPayment = new CardPayment(reference, nif, date, imp);
    }

    @Test
    public void TestingNifGetter () {
        assertEquals(this.nif.toString(), this.cardPayment.getNif());
    }

    @Test
    public void TestingImpGetter () {
        assertEquals(this.imp, this.cardPayment.getImport());
    }

    @Test
    public void TestingDateGetter () {
        assertEquals(this.date.toString(), this.cardPayment.getDate());
    }

    @Test
    public void TestingRefGetter () {
        String ref1 = cardPayment.getReference();
        String ref2 = "123";
        assertEquals(ref1,ref2);
    }

    @Test
    public void TestingToString () {
        String cString = "CardPayment{" + "código operación=" + this.reference + '\''
                + "nif ciudadano'=" + this.nif + '\''
                + "fecha'=" + this.date + '\''
                + "importe del pago='" + this.imp + '\'' + '}';
        assertEquals(cardPayment.toString(), cString);
    }
}
