package PublicAdministrationTests;

import Data.Nif;
import Data.SmallCode;
import PublicAdministration.CreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTest {

    private Nif nif;
    private String cardNum;
    private Date date;
    private SmallCode svc;
    private CreditCard creditCard;
    private int balance;

    @BeforeEach
    public void creditCardForTests () {
        this.nif = new Nif("47320966K");
        this.cardNum = "cardNum";
        this.date = new Date();
        this.svc = new SmallCode("123");
        this.balance = 5000;
        this.creditCard = new CreditCard(nif, cardNum, date, svc, balance);
    }

    @Test
    public void TestingNifGetter () {
        assertEquals(this.nif.toString(), this.creditCard.getNif());
    }

    @Test
    public void TestingCardGetter () {
        assertEquals(this.cardNum, this.creditCard.getCardNumb());
    }

    @Test
    public void TestingDateGetter () {
        assertEquals(this.date.toString(), this.creditCard.getExpirDate());
    }

    @Test
    public void TestingCodeGetter () {
        assertEquals(this.svc.getSvc(), this.creditCard.getSmallCode());
    }

    @Test
    public void TestingBalanceGetter () {
        assertEquals(this.balance, this.creditCard.getBalance());
    }

    @Test
    public void TestingToString () {
        String cString = "CreditCard{" + "nif ciudadano='" + this.nif + '\''
                + "número tarjeta crédito'=" + this.cardNum + '\''
                + "fecha de expiración tarjeta='" + this.date + '\''
                + "código de seguridad='" + this.svc.getSvc() + '\'' + '}';
        assertEquals(creditCard.toString(), cString);
    }
}
