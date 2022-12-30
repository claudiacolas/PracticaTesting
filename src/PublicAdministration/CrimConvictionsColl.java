package PublicAdministration;

import Data.Nif;
import java.util.Arrays;
import java.util.Date;


public class CrimConvictionsColl {

    private final static int CRIMS = 10;

    private Nif nif;
    private CrimConviction[] crimConviction;

    // Represents the total criminal convictions registered for a citizen
    // Its components, that is, the set of criminal convictions

    public CrimConvictionsColl (Nif nif){
        this.nif = nif;
        this.crimConviction = new CrimConviction[CRIMS];
    }

    // the getters

    public String getNif() {
        return nif.toString();
    }

    public CrimConviction[] getCrimConviction() {
        return crimConviction;
    }

    public void addCriminalConviction (CrimConviction crmC){
        if (nextPosition(crimConviction) == -1) {
            resize(crimConviction);
            int addPosition = nextPosition(crimConviction);
            crimConviction[addPosition] = crmC;

        } else {
            int addPosition = nextPosition(crimConviction);
            crimConviction[addPosition] = crmC;
        }
    }

    public CrimConviction getCriminalConviction (Date date) {

        CrimConviction crimConvictionFound = null;
        for (int i = 0; i < crimConviction.length; i++) {
            if (crimConviction[i].getDate() == date.toString()) {
                crimConvictionFound = crimConviction[i];
            }
        }
        return crimConvictionFound;
    } // Gets a specific criminal conviction by date

    public String toString () {
        String crimConvictionCollList = null;
        for (int i = 0; i < crimConviction.length; i++) {
            crimConvictionCollList = "Ciudadano con nif = " + nif + "CrimConviction" + i+1
                    + "{" + "fecha cometido = " + crimConviction[i].getDate()
                    + "ofensa = " + crimConviction[i].getOffense()
                    + "sentencia = " + crimConviction[i].getSentence() +'\n';
        }
        return crimConvictionCollList;
    } // Converts to String

    public void resize (CrimConviction[] crimConviction) {
        int newlenght = crimConviction.length * 2;
        CrimConviction[] crimConviction1 = new CrimConviction[newlenght];
        for (int i= 0; i < crimConviction.length; i++) {
            crimConviction1[i] = crimConviction[i];
        }
    }

    public int size (CrimConviction[] crimConviction) {
        return crimConviction.length;
    }

    public int nextPosition (CrimConviction[] crimConviction) {
        int lastPosition = 0;
        for (int i = 0; i < crimConviction.length; i++) {
            if(crimConviction[i] != null) {
                lastPosition += 1;
            }
        }
        if (lastPosition == crimConviction.length) {
            lastPosition = -1;
        }
        return lastPosition;
    }
}
