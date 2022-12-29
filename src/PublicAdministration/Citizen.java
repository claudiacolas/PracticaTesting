package PublicAdministration;

import Data.Nif;

public class Citizen {

    // Represents all the information required for a citizen
    private Nif nif;
    private String name;
    private String address;
    private String mobileNumb;

    // Other additional information (not required)

    public Citizen (Nif nif, String name, String add, String mobile){
        this.nif = nif;
        this.name = name;
        this.address = add;
        this.mobileNumb = mobile;
    } //  Initializes attributes

    // the getters
    public String getNif() { return nif.toString(); }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getMobileNumb() { return mobileNumb; }

    public String toString () {
        return "Ciudadano{" + "nif ciudadano='" + nif + '\n'
                + "nombre ciudadano='" + name + '\n'
                + "dirección ciudadano='" + address + '\n'
                + "teléfono ciudadano='" + mobileNumb + '\n' + '}';
    } // converts to String

}
