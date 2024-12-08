import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void setup() {
        Configuration.baseUrl = "https://www.simbirsoft.com/";
        Configuration.browser = "edge";
        Configuration.timeout = 5000;
    }
}
