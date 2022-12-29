package PublicAdministration;

import Data.Nif;
import java.math.BigDecimal;
import java.util.Date;

public class CardPayment {

    // The information associated to the payment realized via internet

    private final String reference; // The code of the operation
    private final Nif nif; // The nif of the user
    private final Date date; // The date of the operation
    private final BigDecimal imp; // The import of the payment

    // Constructor: initializes attributes

    public CardPayment (Nif nif, BigDecimal imp, String ref) {
        this.reference = ref;
        this.nif = nif;
        this.date = new Date();
        this.imp = imp;
    }

    // The getters

    public String getReference() { return reference; }
    public String getNif() { return nif.toString(); }
    public String getDate() { return date.toString(); }
    public String getImport() { return imp.toString(); }

    // Converts to String

    @Override
    public String toString () {
        return "CardPayment{" + "código operación=" + reference + '\''
                + "nif ciudadano'=" + nif + '\''
                + "fecha'=" + date + '\''
                + "importe del pago='" + imp + '\'' + '}';
    }
}
