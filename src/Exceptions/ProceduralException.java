package Exceptions;

public class ProceduralException extends Exception{
    public ProceduralException() {
        super("El paso anterior no se ha completado con éxito.");
    }
}
