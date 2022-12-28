package Exceptions;

public class IncompleteFormException extends Exception {
    public IncompleteFormException() {
        super("Campos de información vacíos en el formulario.");
    }
}
