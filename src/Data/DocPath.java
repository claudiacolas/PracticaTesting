package Data;

import java.io.File;

public class DocPath {

    // Ruta en el sistema d'arxius

    private final String docPath;

    public DocPath (String docPath) {

        if(docPath == null || docPath.trim().isEmpty()) {
            throw new IllegalArgumentException("No se ha introducido ninguna ruta.");
        } else if (!isOkayPath(docPath)) {
            throw new IllegalArgumentException("No se ha introducido la ruta correctamente.");
        }

        this.docPath = docPath;
    }

    public String getDocPath() { return docPath; }

    public boolean isOkayPath (String docPath) {

        File path = new File(docPath);

        return path.isDirectory();
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocPath docPathh = (DocPath) o;
        return docPath.equals(docPathh.docPath); }

    @Override
    public int hashCode () { return docPath.hashCode(); }
}
