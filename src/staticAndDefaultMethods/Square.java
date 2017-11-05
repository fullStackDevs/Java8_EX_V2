package staticAndDefaultMethods;

public class Square implements RegularPolygon {

    private int sideLength;

    public Square(int sideLength) {
        this.sideLength = sideLength;
    }

    public int getNumSides() {
        return 4;
    }

    @Override
    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }
}
