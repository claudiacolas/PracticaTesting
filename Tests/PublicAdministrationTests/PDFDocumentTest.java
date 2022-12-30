package PublicAdministrationTests;

import Data.DocPath;
import PublicAdministration.PDFDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PDFDocumentTest {

    private Date createDate;
    private DocPath path;
    private File file;
    private String actPath;
    private PDFDocument pdfDocument;

    @BeforeEach
    public void setPDFDocument() {
        this.actPath = new File(".").getAbsolutePath();
        this.createDate = new Date();
        this.path = new DocPath(actPath);
        this.file = new File(path.getDocPath());
        this.pdfDocument = new PDFDocument();
    }

    @Test
    public void testingDateGetter() {
        assertEquals(this.createDate.toString(), pdfDocument.getDate());
    }

    @Test
    public void testingPathGetter() {
        assertEquals(this.path.toString(), pdfDocument.getPath());
    }

    @Test
    public void testingFileGetter() {
        //assertEquals(new File(this.path.toString()), pdfDocument.getFile());
    }

    @Test
    public void testingToString() {
        String cString = "PDFDocument{" + "fecha creación='" + pdfDocument.getDate() + '\''
                + "ruta documento='" + pdfDocument.getPath() + '\'' + '}';
        assertEquals(pdfDocument.toString(), cString);
    }
}