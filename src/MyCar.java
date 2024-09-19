public class MyCar extends Car {
    public MyCar(String brand, String type, double size) {
        super(brand, type, size);
    }

    private final String info = getBrand() + ' ' + getType() + ' ' + getSize();

    public String infoAboutCar() {
        return info;
    }

    @Override
    public void go() {
        System.out.println(getClass() + "is going");
    }

    @Override
    public void stop() {
        System.out.println(getClass() + "is stopping");
    }
}
