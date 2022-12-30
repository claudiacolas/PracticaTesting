package PublicAdministrationTests;

import Exceptions.InnocentPersonException;
import PublicAdministration.CrimConviction;
import PublicAdministration.CrimConvictionsColl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

public class CrimConvictionsCollTests {

    private CrimConviction crimConviction;
    private CrimConvictionsColl crimConvictionsColl;
    private Date date;

    @BeforeEach
    public void setCrimConvictionsColl() {
        this.crimConvictionsColl = new CrimConvictionsColl();
    }

    @BeforeEach
    public void setCrimConviction() {
        this.date = new Date();
        this.crimConviction = new CrimConviction(date, "offense", "sentece");
    }

    @Test
    public void testingAdd() throws InnocentPersonException {
        crimConvictionsColl.addCriminalConviction(crimConviction);
        assertEquals(this.crimConviction.toString(), crimConvictionsColl.getCriminalConvictions());
    }

    @Test
    public void testingGet() throws InnocentPersonException {
        crimConvictionsColl.addCriminalConviction(crimConviction);
        assertEquals(this.crimConviction.toString(), crimConvictionsColl.getCriminalConviction(date.toString()).toString());
    }

}
