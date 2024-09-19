public class YourCar extends Car implements Drifting{

    public YourCar(String brand, String type, double size) {
        super(brand, type, size);
    }

    @Override
    public void drift() {
        System.out.println(getClass() + "is drifting");
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
