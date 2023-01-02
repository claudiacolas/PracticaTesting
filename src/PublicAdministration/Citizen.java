package PublicAdministration;

import Data.Nif;

public class Citizen {

    // Represents all the information required for a citizen

    private final Nif nif;
    private final String name;
    private final String address;
    private final String mobileNumb;

    //  Initializes attributes

    public Citizen (Nif nif, String name, String add, String mobile){
        this.nif = nif;
        this.name = name;
        this.address = add;
        this.mobileNumb = mobile;
    }

    // The getters

    public String getNif() { return nif.getNif(); }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getMobileNumb() { return mobileNumb; }

    // Converts to String

    @Override
    public String toString () {
        return "Ciudadano{" + "nif ciudadano='" + nif + '\n'
                + "nombre ciudadano='" + name + '\n'
                + "dirección ciudadano='" + address + '\n'
                + "teléfono ciudadano='" + mobileNumb + '\n' + '}';
    }
}
