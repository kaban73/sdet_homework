abstract public class Car implements Moving {
    public static void IsThisCar() {
        System.out.println("This is car");
    }
    private final String brand;
    private final String type;
    private final double size;
    public Car(String brand, String type, double size) {
        this.brand = brand;
        this.type = type;
        this.size = size;
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
}
