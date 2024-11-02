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
    }
}
