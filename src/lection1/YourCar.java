package lection1;

import java.util.Scanner;

public class YourCar extends Car implements Drifting, PoliceStopping{

    private final String yourName;
    public YourCar(String brand, String type, double size, String yourName) {
        super(brand, type, size);
        this.yourName = yourName;
    }

    public void sayYourName() {
        System.out.println(yourName);
    }

    public void isThisYourName() {
        boolean isYourName = false;
        System.out.println("Please enter my name:");
        while (!isYourName) {
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            if (name.equals(yourName))
                isYourName = true;
            else
                System.out.println("This is not my name! Try again");
        }
        System.out.println("Congratulations! You guessed the name");
    }

    @Override
    public void drift() {
        System.out.println(getClass() + " is drifting");
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
        System.out.println("I don't have them. Bye");
    }

    @Override
    public void isThisYourCar(Car car) {
        System.out.println("I don't want to talk with you");
    }

    @Override
    public void getOutOfTheCar() {
        System.out.println("No, bye bye");
        go();
    }
}
