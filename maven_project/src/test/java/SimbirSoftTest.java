import com.codeborne.selenide.Configuration;
import lection_6.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SimbirSoftTest extends BaseTest {
    @BeforeMethod
    void initBeforeMethod() {
        open(Configuration.baseUrl);
    }

    @Test(description = "Show and check feedbackModel")
    public void test() {
        page(new MainPage())
                .showFeedbackModal()
                .checkModalWindowVisible();
        sleep(3000);
    }
}
