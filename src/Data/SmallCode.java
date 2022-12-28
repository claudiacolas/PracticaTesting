package Data;

public class SmallCode {

    // Codi de 3 dígits utilitzat per al Safe Verification Code i també pel Sistema Cl@ve

    private final String svc;

    public SmallCode (String code) {

        if(code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("No se ha introducido ningún código.");
        } else if (!isOkaySvc(code)) {
            throw new IllegalArgumentException("No se ha introducido el código correctamente.");
        }

        this.svc = code;
    }

    public String getSvc() { return svc; }

    public boolean isOkaySvc (String code) {

        if (code.length() != 3) {
            return false;
        } else {
            return code.substring(0, 2).matches("[0-9]*");
        }
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmallCode svcc = (SmallCode) o;
        return svc.equals(svcc.svc); }

    @Override
    public int hashCode () { return svc.hashCode(); }
}
