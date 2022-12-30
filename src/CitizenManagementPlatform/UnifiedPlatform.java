package CitizenManagementPlatform;

import Data.*;
import PublicAdministration.*;
import Services.*;
import Exceptions.*;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Date;

public class UnifiedPlatform {

    //Cas d'ús a desenvolupar: SOL·LICITAR CERTIFICAT D'ANTECEDENTS PENALS

    //Variables

    private Citizen citizen;
    private byte authMethod;
    private Nif nif;
    private SmallCode pin;
    private Citizen persData;
    private Goal gl;
    private CardPayment cardPayment;
    private CertificationAuthority certificationAuthority;
    private GPD gpd;
    private JusticeMinistry justiceMinistry;
    private CAS cas;
    private String nTrans;
    private DocPath path;
    private DigitalSignature digSign;
    private CriminalRecordCertf crc;

    // Constructor

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

    public void setCardPayment (CardPayment cp) { this.cardPayment = cp; }

    // Mètodes a implementar

    public void selectJusMin() {
        System.out.print("MINISTRY OF JUSTICE PUBLIC ADMINISTRATION");
    }

    public void selectProcedures() {
        System.out.print("MINISTRY OF JUSTICE PROCEDURES SECTION");
    }

    public void selectCriminalReportCertf() {
        System.out.print("""
                GETTING YOUR CRIMINAL RECORD CERTIFICATE
                You must be identified. There are different options:
                - Digital Certificate
                - Cl@ve Permanente
                - Cl@ve PIN""");
    }

    public void selectAuthMethod(byte opc) {
        System.out.print("Cl@ve PIN authentication method. You must fill in the form");
        this.authMethod = opc;
    }

    public void enterNIFandPINobt(Nif nif, Date valDate) throws
            NifNotRegisteredException, IncorrectValDateException,
            AnyMobileRegisteredException, ConnectException {
        if (citizen.getNif() == null) {
            throw new NifNotRegisteredException();
        } else if (!certificationAuthority.sendPIN(nif, valDate)) {
            throw new IncorrectValDateException();
        } else if (citizen.getMobileNumb() == null) {
            throw new AnyMobileRegisteredException();
        } else {
            this.nif = nif;
            System.out.print("Now, you can introduce the PIN");
        }
    }

    public void enterPIN(SmallCode pin) throws NotValidPINException,
            ConnectException {
        if (!certificationAuthority.checkPIN(this.nif, pin)) {
            throw new NotValidPINException();
        } else {
            this.pin = pin;
            System.out.print("VALID identification" + "/n" +
                    "Now, we need you to fill in this GPD form to end the process");
        }
    }

    public void enterForm(Citizen citz, Goal goal)
            throws IncompleteFormException, IncorrectVerificationException, ConnectException {
        if (citz == null || goal == null) {
            throw new IncompleteFormException();
        } else if (!gpd.verifyData(citz, goal)) {
            throw new IncorrectVerificationException();
        } else {
            this.persData = citz;
            this.gl = goal;
            System.out.print("VALID identification" + "/n" +
                    "The import is" + "/n" + cardPayment.getImport());
        }
    }

    public void realizePayment() {
        System.out.print("Now, you can introduce your Credit Card data:" + "/n" +
                "Nif:" + "/n" +
                "Card Number:" + "/n" +
                "Expiration Date:" + "/n" +
                "Small Code:");
    }

    public void enterCardData(CreditCard cardD)
            throws IncompleteFormException, NotValidPaymentDataException,
            InsufficientBalanceException, ConnectException {
        if (cardD == null) {
            throw new IncompleteFormException();
        } else if (!cas.askForApproval(nTrans, cardD, new Date(), this.cardPayment.getImport())) {
            throw new NotValidPaymentDataException();
        } else if (this.cardPayment.getImport().intValue() >= cardD.getBalance()) {
            throw new InsufficientBalanceException();
        } else {
            System.out.print("OPERATION ACCEPTED. Below you can get your certificate");
        }
    }

    public void obtainCertificate() throws BadPathException, DigitalSignatureException,
            IOException {
        if (!path.isOkayPath(path.getDocPath())){
            throw new BadPathException();
        } else if (digSign == null) {
            throw new DigitalSignatureException();
        } else {
            this.crc = justiceMinistry.getCriminalRecordCertf(persData, gl);
            PDFDocument pdf = new PDFDocument();
            pdf.openDoc(path);
        }
    }

    // Test methods

    public String getPin() { return this.pin.toString(); }
    public String getPersData() { return this.persData.toString(); }
    public String getGoal() { return this.gl.toString(); }
}
/*
    private void printDocument () { . . . } throws BadPathException, PrintingException;

    // The setter methods for injecting the dependences

    // Other input events (not required)

    // Other internal operations (not required)

    private void registerPayment () { . . . };

    private void openDocument (DocPath path) { . . . } throws BadPathException;

    private void printDocument (DocPath path) { . . . } throws BadPathException, PrintingException;



}
*/
