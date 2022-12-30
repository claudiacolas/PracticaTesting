package DoubleTestClasses;

import Data.Goal;
import Exceptions.DigitalSignatureException;
import PublicAdministration.Citizen;
import PublicAdministration.CriminalRecordCertf;
import Services.JusticeMinistry;

import java.net.ConnectException;

public class JusticeMinistryDouble implements JusticeMinistry {
    @Override
    public CriminalRecordCertf getCriminalRecordCertf(Citizen persD, Goal g) throws DigitalSignatureException, ConnectException {
        return null;
    }
}
