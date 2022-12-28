package Exceptions;

public class IncorrectValDateException extends Exception {
    public IncorrectValDateException() {
        super("El NIF y la fecha introducida no corresponden.");
    }
}
