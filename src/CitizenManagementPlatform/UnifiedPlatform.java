package CitizenManagementPlatform;

import Data.*;
import PublicAdministration.*;
import Services.*;
import Exceptions.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;

public class UnifiedPlatform {

    //Cas d'ús a desenvolupar: SOL·LICITAR CERTIFICAT D'ANTECEDENTS PENALS

    //Variables

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
    private CreditCard creditCard;
    private BigDecimal imp;
    private CriminalRecordCertf crc;
    private boolean previousStepConfirmed = false;

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

    // Mètodes a implementar

    public void selectJusMin() {
        System.out.print("MINISTRY OF JUSTICE PUBLIC ADMINISTRATION");
        this.previousStepConfirmed = true;
    }

    public void selectProcedures() throws ProceduralException {
        isPreviousStepConfirmed();
        System.out.print("MINISTRY OF JUSTICE PROCEDURES SECTION");
        this.previousStepConfirmed = true;

    }

    public void selectCriminalReportCertf() throws ProceduralException {
        isPreviousStepConfirmed();
        System.out.print("""
                GETTING YOUR CRIMINAL RECORD CERTIFICATE
                You must be identified. There are different options:
                - Digital Certificate
                - Cl@ve Permanente
                - Cl@ve PIN""");
        this.previousStepConfirmed = true;
    }

    public void selectAuthMethod(byte opc) throws ProceduralException {
        isPreviousStepConfirmed();
        System.out.print("Cl@ve PIN authentication method. You must fill in the form");
        this.previousStepConfirmed = true;
    }

    public void enterNIFandPINobt(Nif nif, Date valDate) throws
            NifNotRegisteredException, IncorrectValDateException,
            AnyMobileRegisteredException, ConnectException, ProceduralException {
        isPreviousStepConfirmed();
        if (persData.getNif() == null) {
            throw new NifNotRegisteredException();
        } else if (!certificationAuthority.sendPIN(nif, valDate)) {
            throw new IncorrectValDateException();
        } else if (persData.getMobileNumb() == null) {
            throw new AnyMobileRegisteredException();
        } else {
            this.nif = nif;
            System.out.print("Now, you can introduce the PIN");
        }
        this.previousStepConfirmed = true;
    }

    public void enterPIN(SmallCode pin) throws NotValidPINException,
            ConnectException, ProceduralException {
        isPreviousStepConfirmed();
        if (!certificationAuthority.checkPIN(this.nif, pin)) {
            throw new NotValidPINException();
        } else {
            this.pin = pin;
            System.out.print("VALID identification" + "/n" +
                    "Now, we need you to fill in this GPD form to end the process");
        }
        this.previousStepConfirmed = true;
    }

    public void enterForm(Citizen citz, Goal goal)
            throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException {
        isPreviousStepConfirmed();
        if (citz == null || goal == null) {
            throw new IncompleteFormException();
        } else if (!gpd.verifyData(citz, goal)) {
            throw new IncorrectVerificationException();
        } else {
            this.persData = citz;
            this.gl = goal;
            System.out.print("VALID identification" + "/n" +
                    "The import is" + this.imp + "/n" + cardPayment.getImport());
        }
        this.previousStepConfirmed = true;
    }

    public void realizePayment() throws ProceduralException {
        isPreviousStepConfirmed();
        System.out.print("Now, you can introduce your Credit Card data:" + "/n" +
                "Nif:" + "/n" +
                "Card Number:" + "/n" +
                "Expiration Date:" + "/n" +
                "Small Code:");
        this.previousStepConfirmed = true;
    }

    public void enterCardData(CreditCard cardD)
            throws IncompleteFormException, NotValidPaymentDataException,
            InsufficientBalanceException, ConnectException, ProceduralException {
        isPreviousStepConfirmed();
        if (cardD == null) {
            throw new IncompleteFormException();
        } else if (!cas.askForApproval(nTrans, cardD, new Date(), this.imp)) {
            throw new NotValidPaymentDataException();
        } else if (this.imp.intValue() > cardD.getBalance()) {
            throw new InsufficientBalanceException();
        } else {
            this.creditCard = cardD;
            this.cardPayment = new CardPayment(nTrans, this.nif, new Date(), this.imp);
            System.out.print("OPERATION ACCEPTED. Below you can get your certificate");
        }
        this.previousStepConfirmed = true;
    }

    public void obtainCertificate() throws BadPathException, DigitalSignatureException,
            ConnectException, IOException, ProceduralException {
        isPreviousStepConfirmed();
        this.crc = justiceMinistry.getCriminalRecordCertf(persData, gl);
        try {
            openDocument(new DocPath(this.crc.getActPath()));
        } catch (Exception e) {
            throw new BadPathException();
        }
        this.previousStepConfirmed = true;
    }

    private void printDocument () throws BadPathException, PrintingException, ProceduralException {}

    // Intern operations

    private void registerPayment () {}

    private void openDocument (DocPath path) throws BadPathException, IOException {}

    private void printDocument (DocPath path) throws BadPathException, PrintingException, IOException {}

    private void isPreviousStepConfirmed() throws ProceduralException {
        if (!previousStepConfirmed) {
            throw new ProceduralException();
        }
        previousStepConfirmed = false;
    }

    // Test methods

    public String getPin() { return this.pin.toString(); }

    public String getPersData() { return this.persData.toString(); }

    public String getGoal() { return this.gl.toString(); }

    public void setCardPayment (CardPayment cp) { this.cardPayment = cp; }

    public void setImport(BigDecimal imp) { this.imp = imp; }

    public void setPersData (Citizen persData) { this.persData = persData; }

    public void setGoal (Goal goal) { this.gl = goal;}

    public void setPath (DocPath path) { this.path = path; }

    public void setPreviousStepConfirmed (boolean b) { this.previousStepConfirmed = b; }

}

