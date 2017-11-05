package staticAndDefaultMethods;

public interface RegularPolygon {

    int getNumSides();
    int getSideLength();

    static int totalSides(RegularPolygon[] regularPolygons) {
        int totalNrOfSides = 0;
        for(RegularPolygon regularPolygon : regularPolygons){
            totalNrOfSides += regularPolygon.getNumSides();
        }
        return totalNrOfSides;
    }

    default int getPerimeter() {
        return getNumSides() * getSideLength();
    }

    default double getInteriorAngle() {
        int numberOfSides = getNumSides();
        return (numberOfSides - 2) * Math.PI / numberOfSides;
    }
}
