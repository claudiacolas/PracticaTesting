package Services;
import Data.Nif;
import Data.SmallCode;
import Exceptions.AnyMobileRegisteredException;
import Exceptions.IncorrectValDateException;
import Exceptions.NifNotRegisteredException;
import Exceptions.NotValidPINException;
import java.net.ConnectException;
import java.util.Date;

// External service that represents the different trusted certification entities

public interface CertificationAuthority {

    boolean sendPIN (Nif nif, Date date) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException,
            ConnectException;

    boolean checkPIN (Nif nif, SmallCode pin) throws NotValidPINException, ConnectException;
}
