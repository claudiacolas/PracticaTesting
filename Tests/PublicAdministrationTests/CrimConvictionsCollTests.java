package PublicAdministrationTests;


import Data.Nif;
import PublicAdministration.CrimConviction;
import PublicAdministration.CrimConvictionsColl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

public class CrimConvictionsCollTests {
    private Nif nif;
    private CrimConvictionsColl crimConvictionsColl;
    private CrimConviction crimConviction;

    @BeforeEach
    public void nifForTests () {
        this.nif = new Nif("49261475Y");
    }

    @BeforeEach
    public void crimConvictionsCollforTest () {
        this.crimConvictionsColl = new CrimConvictionsColl(this.nif);
    }

    @BeforeEach
    public void crimConviction () {
        this.crimConviction = new CrimConviction(new Date(), "agresión", "culpable");
    }

    @Test
    public void testingNifGetter () {
        String nif = this.nif.toString();
        assertEquals(nif,crimConvictionsColl.getNif());
    }

    @Test
    public void addCrimConvictionTest () {
        crimConvictionsColl.addCriminalConviction(crimConviction);
        assertEquals((this.crimConvictionsColl.getCrimConviction())[0],this.crimConviction);
    }




}
