package Data;

public class Nif {

    // The tax identification number in the Spanish state.

    private final String nif;


    public Nif (String code) {

        if(code == null || code.trim().isEmpty()) {
            throw new NullPointerException("No se ha introducido ningún código.");
        } else if (!isOkayNif(code)) {
            throw new IllegalArgumentException("No se ha introducido el NIF correctamente.");
        }

        this.nif = code;
    }

    public String getNif () { return nif; }

    public boolean isOkayNif (String code) {

        if (code.length() != 9) {
            return false;
        } else {
            return !(!code.substring(0, 7).matches("[0-9]*") & !code.substring(8).matches("[A-Z]*"));
        }
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif niff = (Nif) o;
        return nif.equals(niff.nif); }

    @Override
    public int hashCode () { return nif.hashCode(); }

    @Override
    public String toString () {
        return "Nif{" + "nif ciudadano='" + nif + '\'' + '}';
    }
}
