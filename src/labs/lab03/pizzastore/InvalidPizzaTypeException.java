package labs.lab03.pizzastore;

public class InvalidPizzaTypeException extends Exception{
    public InvalidPizzaTypeException() {
        super("Invalid pizza type");
    }
}
