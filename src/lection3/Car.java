package lection3;

abstract public class Car implements Moving {
    public static void IsThisCar() {
        System.out.println("This is car");
    }
    private final String brand;
    private final String type;
    private final double size;
    private static int totalCarsCreated = 0;
    public Car(String brand, String type, double size) {
        this.brand = brand;
        this.type = type;
        this.size = size;
        totalCarsCreated++;
    }
    protected String getBrand() {
        return brand;
    }
    protected String getType() {
        return type;
    }
    protected double getSize() {
        return size;
    }
    public static int getTotalCarsCreated() {
        return totalCarsCreated;
    }
}
