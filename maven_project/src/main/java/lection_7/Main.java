package lection_7;

import java.sql.SQLException;

public class Main {
    private static final MyDB db = new MyDB("cars");
    public static void main(String[] args) {
        try {
            db.connect();

            db.createTableEx();
            db.readEx();

            db.insertCarEx("VAZ-2107", 50000);
            db.insertCarEx("VAZ-2111", 100000);
            db.insertCarEx("LADA VESTA", 500000);
            db.insertCarEx("LADA NIVA", 1000000);
            db.insertCarEx("LAND CRUISER", 2000000);
            db.readEx();

            db.deleteCarForModelEx("LADA NIVA");
            db.deleteCarForCostLess(70000);
            db.deleteCarForCostMore(1500000);
            db.readEx();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            db.disconnect();
        }
    }

}

