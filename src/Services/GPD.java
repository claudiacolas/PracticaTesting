package Services;

import Data.Goal;
import Exceptions.IncorrectVerificationException;
import PublicAdministration.Citizen;
import java.net.ConnectException;

public interface GPD {
    boolean verifyData(Citizen persData, Goal goal)
            throws IncorrectVerificationException, ConnectException;

}
