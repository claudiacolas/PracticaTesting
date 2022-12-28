package Exceptions;

public class DigitalSignatureException extends Exception {
    public DigitalSignatureException() {
        super("Ha habido un error con la firma electrónica.");
    }
}
