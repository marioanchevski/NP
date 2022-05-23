package labs.lab03.pizzastore;

public class ExtraItem implements Item{
    private String type;

    public ExtraItem(String type) throws InvalidExtraTypeException {
        if (!(type.equals("Ketchup") || type.equals("Coke")))
            throw new InvalidExtraTypeException();
        this.type = type;
    }

    @Override
    public int getPrice() {
        if (type.equals("Ketchup"))
            return 3;
        if (type.equals("Coke"))
            return 5;
        return 0;
    }

    @Override
    public String toString() {
        return type;
    }
}
