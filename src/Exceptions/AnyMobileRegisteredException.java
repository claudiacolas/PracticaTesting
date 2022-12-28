package Exceptions;

public class AnyMobileRegisteredException extends Exception {
    public AnyMobileRegisteredException() {
        super("No existe un móvil registrado.");
    }
}
