public class Main {
    public static void main(String[] args) {
        MyCar myCar = new MyCar(
                "VAZ2107",
                "SEDAN",
                1.6,
                "Ivan"
        );
        YourCar yourCar = new YourCar(
                "VAZ21099",
                "SEDAN",
                1.8,
                "Dmitriy"
        );

        myCar.lookAtMyCar();
        myCar.infoAboutCar();
        myCar.go();
        myCar.stop();

        yourCar.sayYourName();
        yourCar.isThisYourName();
        yourCar.drift();

        System.out.println(Car.getTotalCarsCreated());

        myCar.isThisYourCar(yourCar);
        myCar.showTheDriverLicense();

        yourCar.isThisYourCar(myCar);
        yourCar.getOutOfTheCar();

        Car.IsThisCar();

    }
}
