package Exceptions;

public class NifNotRegisteredException extends Exception {
    public NifNotRegisteredException() {
        super("El NIF introducido no está registrado.");
    }
}
