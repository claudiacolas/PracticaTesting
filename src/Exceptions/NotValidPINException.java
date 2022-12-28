package Exceptions;

public class NotValidPINException extends Exception{
    public NotValidPINException() {
        super("El PIN introducido no es incorrecto.");
    }
}
