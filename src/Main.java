public class Main {
    public static void main(String[] args) {
        MyCar mc = new MyCar(
                "VAZ2107",
                "SEDAN",
                1.6
        );
        YourCar yc = new YourCar(
                "VAZ21099",
                "SEDAN",
                1.8
        );
        mc.infoAboutCar();
        mc.go();
        yc.go();
        System.out.println(yc.getBrand());
        System.out.println(mc.getBrand());
        MyCar.IsThisCar();
    }
}
