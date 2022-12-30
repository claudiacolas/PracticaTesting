package PublicAdministration;

import java.util.Date;

public class CrimConviction {

    // Represents a criminal conviction registered

    private final Date commitDate;

    private final String offense;

    private final String sentence;

    // Constructor

    public CrimConviction (Date commit, String off, String sentc){
        this.commitDate = commit;
        this.offense = off;
        this.sentence = sentc;
    }

    // The getters

    public String getDate() { return commitDate.toString(); }
    public String getOffense() { return offense; }
    public String getSentence() { return sentence; }

    // Converts to String

    public String toString () {
        return "CrimConviction{" + "fecha cometido='" + commitDate + '\'' + "ofensa='" + offense + '\'' + "sentencia='"
                + sentence + '\'' + '}';
    }
}
