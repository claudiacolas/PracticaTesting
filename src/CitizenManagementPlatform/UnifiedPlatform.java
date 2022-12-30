package CitizenManagementPlatform;

import Data.*;
import PublicAdministration.*;
import Services.*;
import Exceptions.*;

import java.net.ConnectException;
import java.util.Date;

public class UnifiedPlatform {

    //Cas d'ús a desenvolupar: SOL·LICITAR CERTIFICAT D'ANTECEDENTS PENALS

    //Variables
    private JusticeMinistry justiceMinistry;
    private CAS cas;
    private CertificationAuthority certificationAuthority;
    private GPD gpd;

    private boolean registered = false; // citizen registered in Cl@ve PIN system

    // Instances created during process
    private Citizen persData;
    private Goal gl;
    private CreditCard credC;
    private CardPayment cPay;
    private PDFDocument doc;

    //Constructor

    public UnifiedPlatform(){
        this.justiceMinistry = null;
        this.cas = null;
        this.certificationAuthority = null;
        this.gpd = null;
    }

    //Setters

    public void setJusticeMinistry(JusticeMinistry justiceMinistry) {
        this.justiceMinistry = justiceMinistry;
    }

    public void setCas (CAS cas) {
        this.cas = cas;
    }

    public void setCertificationAuthority (CertificationAuthority certificationAuthority) {
        this.certificationAuthority = certificationAuthority;
    }

    public void setGpd (GPD gpd) {
        this.gpd = gpd;
    }

    //Mètodes a implementar

    public void selectJusMin () { . . . };

    public void selectProcedures () { . . . };

    public void selectCriminalReportCertf () { . . . };

    public void selectAuthMethod (byte opc) { . . . };

    public void enterNIFandPINobt (Nif nif, Date valDate) throws
            NifNotRegisteredException, IncorrectValDateException,
            AnyMobileRegisteredException, ConnectException {

    }

    public void enterPIN (SmallCode pin) throws NotValidPINException,
            ConnectException {
        //certificationAuthority.sendPIN();
        //certificationAuthority.checkPIN();
    }

    private void enterForm (Citizen citz, Goal goal)
            throws IncompleteFormException, IncorrectVerificationException, ConnectException {
        this.persData = citz;
        this.gl = goal;
        gpd.verifyData(persData, gl);
    }

    private void realizePayment () { . . . };

    private void enterCardData (CreditCard cardD)
            throws IncompleteFormException, NotValidPaymentDataException,
            InsufficientBalanceException, ConnectException {
        this.credC = cardD;
        this.cPay = new CardPayment(new Nif(persData.getNif()), );
        cas.askForApproval(credC);
    }

    private void obtainCertificate () throws BadPathException, DigitalSignatureException,
            ConnectException {
        try {
            this.doc = new CriminalRecordCertf(persData.getNif(), persData.getName(), gl, );
            this.doc.moveDoc("ruta/local/temporal");
            this.doc.openDoc("visualización");
        } catch {
            throw new ProceduralException();
        }
    }

    private void printDocument () { . . . } throws BadPathException, PrintingException;

    // The setter methods for injecting the dependences

    // Other input events (not required)

    // Other internal operations (not required)

    private void registerPayment () { . . . };

    private void openDocument (DocPath path) { . . . } throws BadPathException;

    private void printDocument (DocPath path) { . . . } throws BadPathException, PrintingException;

}
