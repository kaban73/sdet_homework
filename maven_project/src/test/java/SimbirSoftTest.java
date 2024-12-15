import com.codeborne.selenide.Configuration;
import lection_6.dao.Person;
import lection_6.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertEquals;

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

    @Test(description = "Create Person test")
    public void create_person_test() {
        String testName = "Ivanov Ivan Ivanovich";
        int testAge = 20;
        int testWeight = 100;

        Person person = new Person.Builder()
                .withName("Ivanov Ivan Ivanovich")
                .withAge(20)
                .withWeight(100)
                .build();

        assertEquals(testName, person.getPersonName());
        assertEquals(testAge, person.getPersonAge());
        assertEquals(testWeight, person.getPersonWeight());
    }

}
