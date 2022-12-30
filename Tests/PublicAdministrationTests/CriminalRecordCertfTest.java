package PublicAdministrationTests;

import Data.DigitalSignature;
import Data.Goal;
import Data.Nif;
import PublicAdministration.CrimConvictionsColl;
import PublicAdministration.CriminalRecordCertf;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CriminalRecordCertfTest {

    private Nif nif;
    private String name;
    private DigitalSignature sig;
    private CrimConvictionsColl ccc;
    private Goal goal;

    private CriminalRecordCertf criminalRecordCertf;
    private byte[] digSign;


    @BeforeEach
    public void setCriminalRecordCertf() {
        this.nif = new Nif("47320966K");
        this.name = "Anxi";
        this.goal = Goal.GAMESECTOR;
        this.digSign = new byte[10];
        this.sig = new DigitalSignature(digSign);
        this.ccc = new CrimConvictionsColl();
        this.criminalRecordCertf = new CriminalRecordCertf(nif, name, goal, sig, ccc);
    }

    @Test
    public void testingNifGetter() {
        assertEquals(this.nif.toString(), this.criminalRecordCertf.getNif());
    }

    @Test
    public void testingNameGetter() {
        assertEquals(this.name, this.criminalRecordCertf.getName());
    }

    @Test
    public void testingGoalGetter() {
        assertEquals(this.goal.toString(), this.criminalRecordCertf.getGoal());
    }

    @Test
    public void testingSigGetter() {
        assertEquals(this.sig.toString(), this.criminalRecordCertf.getDigSign());
    }

    @Test
    public void testingCrimGetter() {
        assertEquals(this.ccc.toString(), this.criminalRecordCertf.getCrimConvs());
    }
}