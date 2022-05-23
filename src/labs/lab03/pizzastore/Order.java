package labs.lab03.pizzastore;

public class Order {
    private Item[] items;
    private int numbeOfItems;
    private boolean isLocked;

    public Order(){
        items = new Item[10];
        numbeOfItems = 0;
        isLocked = false;
    }

    public void addItem(Item item, int count) throws ItemOutOfStockException {
        if (count > 10)
            throw new ItemOutOfStockException(item);

        int index = findIndex(item);
        if (index==-1){
            items[numbeOfItems++] = item;
        }
        else{
            //items[index].
        }

    }

    public int getPrice(){
        return 1;
    }

    private int findIndex(Item item){
        int index = -1;
        for (int i=0;i<numbeOfItems;i++){
            if (item.toString().equals(item.toString()))
                index = i;
        }
        return index;

    }

    public void displayOrder(){

    }

    public void removeItem(int idx){

    }

    public void lock(){

    }
}
