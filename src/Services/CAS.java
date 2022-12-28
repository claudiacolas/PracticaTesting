package Services;

import Exceptions.InsufficientBalanceException;
import Exceptions.NotValidPaymentDataException;
import PublicAdministration.CreditCard;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;

// External service that represents the Credit Authorization Service

public interface CAS {
        boolean askForApproval(String nTrans, CreditCard cardData,
                               Date date, BigDecimal imp) throws NotValidPaymentDataException, InsufficientBalanceException, ConnectException;
}
