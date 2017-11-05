package staticAndDefaultMethods;

public class EquilateralTriangle implements RegularPolygon {

    private int sideLength;

    public EquilateralTriangle(int sideLength) {
        this.sideLength = sideLength
    }

    public int getNumSides() {
        return 3;
    }

    @Override
    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }
}
