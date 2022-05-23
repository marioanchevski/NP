package labs.lab01.objects;

import java.util.Arrays;

public class MovablesCollection {
    private Movable[] movables;
    private  int x_MAX;
    private  int y_MAX;

    public MovablesCollection(int x_MAX, int y_MAX) {
        this.x_MAX =x_MAX;
        this.y_MAX=y_MAX;
    }

    public void addMovableObject(Movable m){
       // if (m instanceof )
    }

    public void moveObjectsFromTypeWithDirection (TYPE type, DIRECTION direction){

    }

    @Override
    public String toString() {
        return "Collection of movable objects with size [големина на колекцијата]";
    }
}
