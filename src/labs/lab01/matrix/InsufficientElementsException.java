package labs.lab01.matrix;

public class InsufficientElementsException extends Exception{
    public InsufficientElementsException(){
        super("Insufficient number of elements");
    }
}
