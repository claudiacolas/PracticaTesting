package PublicAdministration;

import Data.Nif;
import Data.SmallCode;
import java.util.Date;

public class CreditCard {

    // The payment information for using the card via internet

    private final Nif nif; // The nif of the user
    private final String cardNumb; // The number of the credit card
    private final Date expirDate; // The expiration date for the credit card
    private final SmallCode svc; // The Safe Verification Code

    // Constructor

    public CreditCard (Nif nif, String cNum, Date d, SmallCode c) { // Initializes attributes
        this.nif = nif;
        this.cardNumb = cNum;
        this.expirDate = d;
        this.svc = c;
    }

    // Getters

    public String getNif() { return nif.toString(); }
    public String getCardNumb() { return cardNumb; }
    public String getExpirDate() { return expirDate.toString(); }
    public String getSmallCode() { return svc.getSvc(); }

    // Converts to String

    @Override
    public String toString () {
        return "CreditCard{" + "nif ciudadano='" + nif + '\''
                + "número tarjeta crédito'=" + cardNumb + '\''
                + "fecha de expiración tarjeta='" + expirDate + '\''
                + "código de seguridad='" + svc.getSvc() + '\'' + '}';
    }
}
