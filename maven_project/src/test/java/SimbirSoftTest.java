import com.codeborne.selenide.Configuration;
import lection_6.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SimbirSoftTest extends BaseTest {
    @BeforeMethod
    void initBeforeMethod() {
        open(Configuration.baseUrl);
    }

    @Test(description = "Show and check feedbackModel")
    public void show_and_check_feedbackModel() {
        page(new MainPage())
                .showFeedbackModal()
                .checkModalWindowVisible()
                .checkInputNameOrOrganization();
        sleep(3000);
    }
    @Test(description = "hover navSub and go to Contacts")
    public void open_contactsPage() {
        page(new MainPage())
                .openNavSubBox()
                .checkNavSubBoxVisible()
                .clickSubLinkContacts()
                .checkContactsPage();
        sleep(3000);
    }

}
