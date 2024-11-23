import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TestNGExample {
    private int num;
    private static final String USER_NAME = "login";
    private static final String USER_PASSWORD = "password";


    @BeforeClass
    public void setup(){
        num = 2;
    }

    @AfterClass
    public void tearDown() {
        num = 0;
    }

    @Test(groups = "regress")
    public void simple_calc_test1_correct() {
        assertEquals(2 + 3, 5, "Wrong number");
    }

    @Test(groups = "regress")
    public void simple_calc_test1_wrong() {
        assertNotEquals(2 + 3, 6, "Wrong number");
    }

    @Test
    public void simple_calc_test() {
        assertEquals(num + 2, 4, "Wrong Number");
    }

    @Test(
            description = "Simple params test",
            groups = "params_test"
    )
    @Parameters({"name", "password"})
    public void parameterized_test(String name, String password) {
        assertEquals(name, USER_NAME, "Wrong user name");
        assertEquals(password, USER_PASSWORD, "Wrong user password");
    }

    @Test(
            dataProvider = "credits",
            enabled = true,
            groups = "params_test"
    )
    public void data_provider_test(String name, String password) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(name, USER_NAME, "Wrong user name");
        softAssert.assertEquals(password, USER_PASSWORD, "Wrong user password");
        softAssert.assertAll();
    }

    @DataProvider(name = "credits")
    public static Object[][] creditsProvider() {
        return new Object[][] {
                {"login", "password"},
                {"login", "password2"},
                {"login3", "password"},
                {"login4", "password4"}
        };
    }
}
