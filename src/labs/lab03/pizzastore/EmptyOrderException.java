package labs.lab03.pizzastore;

public class EmptyOrderException extends Exception{
    public EmptyOrderException() {
        super("Empty Order");
    }
}
