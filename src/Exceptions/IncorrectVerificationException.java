package Exceptions;

public class IncorrectVerificationException extends Exception {
    public IncorrectVerificationException() {
        super("La verificación no se ha realizado con éxito.");
    }
}
