package labs.lab01.objects;

public class MovingCircle implements Movable {
    private int radius;
    private MovingPoint center;

    public MovingCircle(int radius, MovingPoint center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public int getCurrentXPosition() {
        return 0;
    }

    @Override
    public int getCurrentYPosition() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Movable circle with center coordinates (%d,%d) and radius %d",
                center.getCurrentXPosition(),center.getCurrentYPosition(), radius);
    }
}
