package lection3;

import java.util.Objects;

public class MyCar extends Car implements PoliceStopping {
    private final String myName;

    public MyCar(String brand, String type, double size, String myName) {
        super(brand, type, size);
        this.myName = myName;
    }

    private final String info = getBrand() + ' ' + getType() + ' ' + getSize() + ' ' + getMyName();

    public void infoAboutCar() {
        System.out.println(info);
    }
    public String getMyName() {
        return myName;
    }

    public void lookAtMyCar() {
        if (Objects.equals(getBrand(), "BMW"))
            System.out.println("This is so cool BMW");
        else
            System.out.println("This is so cool " + getBrand());
    }

    @Override
    public void go() {
        System.out.println(getClass() + " is going");
    }

    @Override
    public void stop() {
        System.out.println(getClass() + " is stopping");
    }

    @Override
    public void showTheDriverLicense() {
        System.out.println("Take my driver's license");
    }

    @Override
    public void isThisYourCar(Car car) {
        if (car.getBrand().equals(getBrand())
        && car.getType().equals(getType())
        && car.getSize() == getSize()
        )
            System.out.println("Yes, this is my car");
        else
            System.out.println("No, this is not my car");
    }

    @Override
    public void getOutOfTheCar() {
        System.out.println("Okay, wait a minute");
    }
}
