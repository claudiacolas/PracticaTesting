package PublicAdministrationTests;

import Data.Nif;
import PublicAdministration.CardPayment;
import PublicAdministration.CrimConviction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrimConvictionTests {

    private CrimConviction crimConviction;

    @BeforeEach
    public void crimConvictionForTests () {
        Date commitDate = new Date();
        String offense = "agresión";
        String sentence = "culpable";
        this.crimConviction = new CrimConviction(commitDate,offense,sentence);
    }

    @Test
    public void testingToString () {
        String cCString = "CrimConviction{" + "fecha cometido='" + crimConviction.getDate() + '\'' + "ofensa='" + crimConviction.getOffense() + '\'' + "sentencia='"
                + crimConviction.getSentence() + '\'' + '}';
        assertEquals(cCString,crimConviction.toString());
    }

    @Test
    public void testingDateGetter () {
        String date = (new Date()).toString();
        assertEquals(date,crimConviction.getDate());
    }

    @Test
    public void testingOffenseGetter () {
        String offense = "agresión";
        assertEquals(offense,crimConviction.getOffense());
    }

    @Test
    public void testingSentenceGetter () {
        String sentence = "culpable";
        assertEquals(sentence,crimConviction.getSentence());
    }
}
