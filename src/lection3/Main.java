package lection3;

public class Main {
    public static void main(String[] args) {
        Garage<Car> carGarage = new Garage<>();
        carGarage.getCount();

        MyCar myCar = new MyCar(
                "VAZ2107",
                "SEDAN",
                1.6,
                "Ivan"
        );
        carGarage.addAnything(myCar);
        YourCar yourCar = new YourCar(
                "VAZ21099",
                "SEDAN",
                1.8,
                "Dmitriy"
        );
        carGarage.addAnything(yourCar);

        carGarage.getCount();

        carGarage.removeAnything(yourCar);
        carGarage.getCount();

        carGarage.getAnything(myCar);
        carGarage.getAnything(yourCar);
        carGarage.getAllAnythings();

        Garage<String> stringGarage = new Garage<>();
        stringGarage.addAnything("Hello");
        stringGarage.addAnything("Bye");
        stringGarage.getAllAnythings();

        Garage<Object> objectGarage = new Garage<>();
        objectGarage.addAnything(myCar);
        objectGarage.addAnything(yourCar);
        objectGarage.addAnything("Hello");
        objectGarage.addAnything(1);
        objectGarage.getAllAnythings();

        /*
         *  Так как Garage - это дженерик класс, то в нем могут содержаться объекты тех типов, которые мы укажем
         *  Поэтому для примера я создал два гаража только для определенных типов
         *  И еще один гараж, который может вмещать в себя все что угодно, как и в реальной жизни в общем)
         */

        NumberCheck<Integer> isIntegerDividedBy13 = num -> num % 13 == 0;
        System.out.println(isIntegerDividedBy13.check(3));
        NumberCheck<Float> isFloatDividedBy13 = num -> num % 13 == 0;
        System.out.println(isFloatDividedBy13.check(13f));

        GetDiscriminant<Float> floatDiscriminant = (a, b, c) -> b*b - 4*a*c;
        System.out.println(floatDiscriminant.calculation(2f, 9f, 4f));
    }
    @FunctionalInterface
    interface NumberCheck<T extends Number> {
        boolean check(T num);
    }
    @FunctionalInterface
    interface GetDiscriminant<T extends Float> {
        T calculation(T a, T b, T c);
    }
}
