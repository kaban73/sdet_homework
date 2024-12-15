package lection_6.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class ContactsPage {
    private final String CONTACTS_PAGE_DIV = "//div[@data-is=\"box-contacts\"]";
    @FindBy(xpath = CONTACTS_PAGE_DIV)
    private SelenideElement contactsPageDiv;

    public void checkContactsPage() {
        contactsPageDiv.shouldBe(visible);
    }

}
