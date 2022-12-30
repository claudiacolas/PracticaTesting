package PublicAdministration;

import Exceptions.InnocentPersonException;
import java.util.ArrayList;
import java.util.List;

public class CrimConvictionsColl {

    // Represents the total criminal convictions registered for a citizen

    private final List<CrimConviction> criminalConvictions;

    // Initializes the object
    public CrimConvictionsColl (){
        this.criminalConvictions = new ArrayList<>();
    }

    // The getters

    public String getCriminalConvictions() throws InnocentPersonException {
        for (CrimConviction criminalConviction : this.criminalConvictions) {
            return criminalConviction.toString();
        }
        throw new InnocentPersonException();
    }

    // Adds a criminal conviction

    public void addCriminalConviction (CrimConviction crmC){
        this.criminalConvictions.add(crmC);
    }

    // Gets a specific criminal conviction by date

    public CrimConviction getCriminalConviction (String date) throws InnocentPersonException {
        for (CrimConviction cr : this.criminalConvictions) {
            if (cr.getDate().equals(date)) {
                return cr;
            }
        }
        throw new InnocentPersonException();
    }

    // Converts to String

    public String toString () {
        StringBuilder crBuilder = new StringBuilder();
        for (CrimConviction cr : this.criminalConvictions) {
            String crString = cr.toString();
            crBuilder.append(crString);
        }
        return criminalConvictions.toString();
    }
}
