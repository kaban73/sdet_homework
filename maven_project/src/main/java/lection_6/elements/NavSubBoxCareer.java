package lection_6.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lection_6.pages.CareerPage;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class NavSubBoxCareer {
    private final String NAV_SUB_BOX_CAREER = "//div[@class=\"gh-nav-item gh-nav-item--career\"]//div[@class=\"gh-nav-sub-box\"]";
    @FindBy(xpath = NAV_SUB_BOX_CAREER)
    private SelenideElement navSubBoxCareer;
    @FindBy(xpath = NAV_SUB_BOX_CAREER + "//a[@href=\"/career/friends/\"]")
    private SelenideElement navSubLinkFriends;
    @FindBy(xpath = NAV_SUB_BOX_CAREER + "//a[@href=\"/career/\"]")
    private SelenideElement navSubLinkCareer;

    @Step("Проверить, что скрытое меню навигации для элемента \"Карьера\" видимо")
    public NavSubBoxCareer navSubBoxCareerIsVisible() {
        navSubBoxCareer.shouldBe(visible);
        return this;
    }
    @Step("Проверить, что элемент скрытого меню \"Работа в SimbirSoft\" виден и нажать на него")
    public CareerPage clickSubLinkCareer() {
        navSubLinkCareer
                .shouldBe(visible)
                .click();
        return page(CareerPage.class);
    }
}
