package DoubleTestClasses;

import Data.Nif;
import Data.SmallCode;
import Exceptions.*;
import Services.CertificationAuthority;

import java.net.ConnectException;
import java.util.Date;

public class CertificationAuthorityExceptionDouble implements CertificationAuthority {
    @Override
    public boolean sendPIN(Nif nif, Date date) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException {
        return false;
    }

    @Override
    public boolean checkPIN(Nif nif, SmallCode pin) throws NotValidPINException, ConnectException {
        return false;
    }
}
