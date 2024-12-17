package lection_6.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lection_6.pages.ContactsPage;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class NavSubBoxAbout {
    private final String NAV_SUB_BOX_ABOUT = "//div[@class=\"gh-nav-item gh-nav-item--about\"]//div[@class=\"gh-nav-sub-box\"]";
    @FindBy(xpath = NAV_SUB_BOX_ABOUT)
    private SelenideElement navSubBoxAbout;
    @FindBy(xpath = NAV_SUB_BOX_ABOUT + "//a[@href=\"/contacts/\"]")
    private SelenideElement navSubLinkContacts;
    @Step("Проверить, что скрытое меню навигации для элемента \"О нас\" видимо")
    public NavSubBoxAbout navSubBoxIsVisible() {
        navSubBoxAbout.shouldBe(visible);
        return this;
    }
    @Step("Проверить, что элемент скрытого меню \"Контакты\" виден и нажать на него")
    public ContactsPage clickSubLinkContacts() {
        navSubLinkContacts
                .shouldBe(visible)
                .click();
        return page(ContactsPage.class);
    }
}
