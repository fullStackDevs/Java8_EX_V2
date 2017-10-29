
public class Car {
    private String brand;
    private String color;
    private int fabricationYear;

    public Car(String brand, String color, int fabricationYear) {
        this.brand = brand;
        this.color = color;
        this.fabricationYear = fabricationYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(int fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", fabricationYear=" + fabricationYear +
                '}';
    }
}
