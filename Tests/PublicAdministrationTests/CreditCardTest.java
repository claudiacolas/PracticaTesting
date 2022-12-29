package PublicAdministrationTests;

import Data.Nif;
import Data.SmallCode;
import PublicAdministration.CreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTest {

    private CreditCard creditCard;

    @BeforeEach
    public void creditCardForTests () {
        Nif nif = new Nif("47320966K");
        Date date = new Date();
        SmallCode code = new SmallCode("123");
        this.creditCard = new CreditCard(nif, "cardNum", date, code);
    }

    @Test
    public void TestingNifGetter () {
        String nif1 = creditCard.getNif();
        String nif2 = "Nif{nif ciudadano='47320966K'}";
        assertEquals(nif1,nif2);
    }

    @Test
    public void TestingCardGetter () {
        String card1 = creditCard.getCardNumb();
        String card2 = "cardNum";
        assertEquals(card1,card2);
    }

    @Test
    public void TestingDateGetter () {
        String date1 = creditCard.getExpirDate();
        String date2 = (new Date()).toString();
        assertEquals(date1,date2);
    }

    @Test
    public void TestingCodeGetter () {
        String code1 = creditCard.getSmallCode();
        String code2 = "123";
        assertEquals(code1,code2);
    }

    @Test
    public void TestingToString () {
        String cString = "CreditCard{" + "nif ciudadano='" + creditCard.getNif() + '\''
                + "número tarjeta crédito'=" + creditCard.getCardNumb() + '\''
                + "fecha de expiración tarjeta='" + creditCard.getExpirDate() + '\''
                + "código de seguridad='" + creditCard.getSmallCode() + '\'' + '}';
        assertEquals(creditCard.toString(), cString);
    }
}
