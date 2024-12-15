package lection_6;

import com.codeborne.selenide.SelenideElement;
import lection_6.pages.ContactsPage;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class NavSubBox {
    private final String NAV_SUB_BOX = "//div[@class=\"gh-nav-item gh-nav-item--about\"]//div[@class=\"gh-nav-sub-box\"]";
    @FindBy(xpath = NAV_SUB_BOX)
    private SelenideElement navSubBox;
    @FindBy(xpath = NAV_SUB_BOX + "//a[@href=\"/contacts/\"]")
    private SelenideElement navSubLinkContacts;

    public NavSubBox checkNavSubBoxVisible() {
        navSubBox.shouldBe(visible);
        return this;
    }
    public ContactsPage clickSubLinkContacts() {
        navSubLinkContacts
                .shouldBe(visible)
                .click();
        return page(ContactsPage.class);
    }
}
