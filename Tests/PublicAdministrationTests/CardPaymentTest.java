package PublicAdministrationTests;

import Data.Nif;
import PublicAdministration.CardPayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardPaymentTest {

    private CardPayment cardPayment;

    @BeforeEach
    public void cardPaymentForTests() {
        Nif nif = new Nif("47320966K");
        BigDecimal imp = new BigDecimal("56.89");
        String ref = "123";
        this.cardPayment = new CardPayment(nif, imp, ref);
    }

    @Test
    public void TestingNifGetter () {
        String nif1 = cardPayment.getNif();
        String nif2 = "Nif{nif ciudadano='47320966K'}";
        assertEquals(nif1,nif2);
    }

    @Test
    public void TestingImpGetter () {
        String imp1 = cardPayment.getImport();
        String imp2 = "56.89";
        assertEquals(imp1,imp2);
    }

    @Test
    public void TestingDateGetter () {
        String date1 = cardPayment.getDate();
        String date2 = (new Date()).toString();
        assertEquals(date1,date2);
    }

    @Test
    public void TestingRefGetter () {
        String ref1 = cardPayment.getReference();
        String ref2 = "123";
        assertEquals(ref1,ref2);
    }

    @Test
    public void TestingToString () {
        String cString = "CardPayment{" + "código operación=" + cardPayment.getReference() + '\''
                + "nif ciudadano'=" + cardPayment.getNif() + '\''
                + "fecha'=" + cardPayment.getDate() + '\''
                + "importe del pago='" + cardPayment.getImport() + '\'' + '}';
        assertEquals(cardPayment.toString(), cString);
    }
}
