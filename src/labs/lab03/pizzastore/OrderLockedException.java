package labs.lab03.pizzastore;

public class OrderLockedException extends Exception{
    public OrderLockedException() {
        super("Order locked");
    }
}
