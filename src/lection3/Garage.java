package lection3;

import java.util.ArrayList;
import java.util.List;

public class Garage<T> implements ReorganizeGarage<T> {
    private final List<T> anythings = new ArrayList<>();
    public void getCount() {
        System.out.println(anythings.size());
    }
    public void getAnything(T anything) {
        if (anythings.contains(anything))
            System.out.println(("there is a " + anything.getClass() + " in the garage"));
        else
            System.out.println(("there is not a " + anything.getClass() + " in the garage"));
    }

    public void getAllAnythings() {
        System.out.println(anythings);
    }

    @Override
    public void addAnything(T anything) {
        try {
            anythings.add(anything);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeAnything(T anything) {
        try {
            anythings.remove(anything);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
