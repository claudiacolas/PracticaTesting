package UnifiedPlatformTests;

import CitizenManagementPlatform.UnifiedPlatform;
import Data.DocPath;
import Data.Goal;
import Data.Nif;
import DoubleTestClasses.JusticeMinistryDouble;
import Exceptions.BadPathException;
import Exceptions.DigitalSignatureException;
import Exceptions.ProceduralException;
import PublicAdministration.Citizen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ObtainCertificateTest {

    private UnifiedPlatform unifiedPlatform;
    private Citizen persData;
    private Goal goal;
    private Nif nif;
    private DocPath path;

    @BeforeEach
    public void setUp() {
        unifiedPlatform = new UnifiedPlatform();
        this.nif = new Nif("12345678A");
        this.persData = new Citizen(nif, "Montse", "address", "666666666");
        this.goal = Goal.PUBLICWORKERS;
        unifiedPlatform.setPreviousStepConfirmed(true);
    }

    @Test
    public void testingObtainingCertfSuccess() throws DigitalSignatureException, IOException, BadPathException, ProceduralException {
        unifiedPlatform.setJusticeMinistry(new JusticeMinistryDouble());
        unifiedPlatform.setPersData(persData);
        unifiedPlatform.setGoal(goal);
        unifiedPlatform.obtainCertificate();
    }

}
