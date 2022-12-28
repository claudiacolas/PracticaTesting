package Services;

import Data.Goal;
import Exceptions.DigitalSignatureException;
import PublicAdministration.Citizen;
import PublicAdministration.CriminalRecordCertf;
import java.net.ConnectException;

public interface JusticeMinistry {
    CriminalRecordCertf getCriminalRecordCertf (Citizen persD, Goal g)
            throws DigitalSignatureException, ConnectException;
}
