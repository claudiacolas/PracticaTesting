package PublicAdministrationTests;

import PublicAdministration.CrimConviction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrimConvictionTests {

    private Date commitDate;
    private String offense;
    private String sentence;
    private CrimConviction crimConviction;

    @BeforeEach
    public void crimConvictionForTests () {
        this.commitDate = new Date();
        this.offense = "agresión";
        this.sentence = "culpable";
        this.crimConviction = new CrimConviction(commitDate,offense,sentence);
    }

    @Test
    public void testingDateGetter () {
        assertEquals(this.commitDate.toString(), crimConviction.getDate());
    }

    @Test
    public void testingOffenseGetter () {
        assertEquals(this.offense, crimConviction.getOffense());
    }

    @Test
    public void testingSentenceGetter () {
        assertEquals(this.sentence, crimConviction.getSentence());
    }

    @Test
    public void testingToString () {
        String cCString = "CrimConviction{" + "fecha cometido='" +
                this.commitDate.toString() + '\'' + "ofensa='" +
                this.offense + '\'' + "sentencia='"
                + this.sentence + '\'' + '}';
        assertEquals(cCString, crimConviction.toString());
    }
}
