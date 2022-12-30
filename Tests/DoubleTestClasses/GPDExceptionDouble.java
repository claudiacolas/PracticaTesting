package DoubleTestClasses;

import Data.Goal;
import Exceptions.IncorrectVerificationException;
import PublicAdministration.Citizen;
import Services.GPD;

import java.net.ConnectException;

public class GPDExceptionDouble implements GPD {
    @Override
    public boolean verifyData(Citizen persData, Goal goal) throws IncorrectVerificationException, ConnectException {
        return false;
    }
}
