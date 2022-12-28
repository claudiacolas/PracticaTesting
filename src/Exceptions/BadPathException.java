package Exceptions;

public class BadPathException extends Exception {
    public BadPathException() {
        super("Ha habido un problema en las operaciones de acceso al directorio de archivos.");
    }
}
