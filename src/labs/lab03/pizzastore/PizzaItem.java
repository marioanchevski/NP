package labs.lab03.pizzastore;

public class PizzaItem implements Item{
    private String type;

    public PizzaItem(String type) throws InvalidPizzaTypeException {
        if (!(type.equals("Standard") || type.equals("Pepperon") || type.equals("Vegetarian")))
            throw new InvalidPizzaTypeException();
        this.type = type;
    }

    @Override
    public int getPrice() {
        if (type.equals("Standard"))
            return 10;
        if (type.equals("Pepperoni"))
            return 12;
        if (type.equals("Vegetarian"))
            return 8;
        return 0;
    }

    @Override
    public String toString() {
        return type;
    }
}
