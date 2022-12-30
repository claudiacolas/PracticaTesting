package PublicAdministration;

import Data.DocPath;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.nio.file.Files;

public class PDFDocument {

    private Date createDate;
    private DocPath path;
    private File file;
    private String actpath;

    // Constructor: initializes attributes and emulates the document download at a default path

    public PDFDocument () {
        String actpath = new File(".").getAbsolutePath();
        this.createDate = new Date();
        this.path = new DocPath(actpath);
        this.file = new File(path.getDocPath());
    }

    // The getters

    public String getDate () { return createDate.toString(); }
    public String getPath () { return path.toString(); }
    public String getActPath() { return actpath; }
    public String getFile () { return file.toString();}

    // Converts to String members Date & DocPath

    public String toString () {
        return "PDFDocument{" + "fecha creación='" + createDate + '\'' + "ruta documento='" + path + '\'' + '}';
    }

    // Moves the document to the destination path indicated

    public void moveDoc(DocPath destPath) throws IOException {
        File newPlace = new File(destPath.getDocPath());
        try {
            Files.move(file.toPath(), newPlace.toPath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Opens the document at the path indicated

    public void openDoc(DocPath path) throws IOException {
        try {
            File place = new File(String.valueOf(path));
            Desktop.getDesktop().open(place);
        } catch (IOException ex) {ex.printStackTrace();
        }
    }
}
