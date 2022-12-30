package PublicAdministration;

import java.util.Date;

public class CrimConviction {

    // Represents a criminal conviction registered
    // S'haurà d'implementar de manera que es faciliti la consulta de les condenes per data

    private Date commitDate;

    private String offense;

    private String sentence;

    public CrimConviction (Date commit, String off, String sentc){
        this.commitDate = commit;
        this.offense = off;
        this.sentence = sentc;
    }

    // the getters
    public String getDate() { return commitDate.toString(); }
    public String getOffense() { return offense; }
    public String getSentence() { return sentence; }

    public String toString () {
        return "CrimConviction{" + "fecha cometido='" + commitDate + '\'' + "ofensa='" + offense + '\'' + "sentencia='"
                + sentence + '\'' + '}';
    } // converts to String
}
