package staticAndDefaultMethods;

public class Main {

    public static void main(String[] args) {

        RegularPolygon square_1 = new Square(5);
        RegularPolygon equilateralTriangle_1 = new EquilateralTriangle(8);

        RegularPolygon[] polygons = new RegularPolygon[]{square_1, equilateralTriangle_1};
        System.out.println("Total number of sides from the 'polynoms' array is: " + RegularPolygon.totalSides(polygons));

        System.out.println("The perimeter of the square_1 is: " + square_1.getPerimeter());
        System.out.println("The perimeter of the equilateralTriangle_1 is: " + equilateralTriangle_1.getPerimeter());

        System.out.println("The interiour angle of the square_1 is: " + square_1.getInteriorAngle());
        System.out.println("The interiour angle of the equilateralTriangle_1 is " + equilateralTriangle_1.getInteriorAngle());


    }
}
