package DoubleTestClasses;

import Exceptions.InsufficientBalanceException;
import Exceptions.NotValidPaymentDataException;
import PublicAdministration.CreditCard;
import Services.CAS;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;

public class CASDouble implements CAS {
    @Override
    public boolean askForApproval(String nTrans, CreditCard cardData, Date date, BigDecimal imp) throws NotValidPaymentDataException, InsufficientBalanceException, ConnectException {
        return true;
    }
}
