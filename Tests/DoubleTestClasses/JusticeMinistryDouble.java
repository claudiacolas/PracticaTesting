package DoubleTestClasses;

import Data.*;
import Exceptions.DigitalSignatureException;
import PublicAdministration.*;
import Services.JusticeMinistry;

import java.net.ConnectException;

public class JusticeMinistryDouble implements JusticeMinistry {

    private DigitalSignature digsig;
    private CrimConvictionsColl ccc;
    @Override
    public CriminalRecordCertf getCriminalRecordCertf(Citizen persD, Goal g)
            throws DigitalSignatureException, ConnectException {
        return new CriminalRecordCertf(new Nif(persD.getNif()), persD.getName(), g, this.digsig, this.ccc);
    }
}
