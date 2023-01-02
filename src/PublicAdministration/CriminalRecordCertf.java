package PublicAdministration;

import Data.DigitalSignature;
import Data.Goal;
import Data.Nif;

public class CriminalRecordCertf extends PDFDocument {

    private Nif nif;
    private String name;
    private Goal goal;
    private DigitalSignature digSign;
    private CrimConvictionsColl crimConvs;

    // Constructor: initializes attributes

    public CriminalRecordCertf (Nif nif, String name, Goal g,
                                DigitalSignature ds, CrimConvictionsColl crmC) {
        this.nif = nif;
        this.name = name;
        this.goal = g;
        this.digSign = ds;
        this.crimConvs = crmC;
    }

    // The getters

    public String getNif() { return nif.toString(); }
    public String getName() { return name; }
    public String getGoal() { return goal.toString(); }
    public String getDigSign() { return digSign.toString(); }
    public String getCrimConvs() { return crimConvs.toString(); }
}