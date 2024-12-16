package lection_6.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class NavBar {
    private static final String NAV_BAR_LOGO = "//div[@class=\"is-wrapper-a\"]//div[@class=\"gh-logo\"]";
    private static final String NAV_BAR_NAV = "//div[@class=\"is-wrapper-a\"]//div[@class=\"gh-nav\"]";
    private static final String NAV_BAR_TOOLS = "//div[@class=\"is-wrapper-a\"]//div[@class=\"gh-tools\"]";

    @FindBy(xpath = NAV_BAR_LOGO)
    private SelenideElement navBarLogo;
    @FindBy(xpath = NAV_BAR_NAV + "//a[@href=\"/portfolio/\"]")
    private SelenideElement navItemProjects;
    @FindBy(xpath = NAV_BAR_NAV + "//a[@href=\"/help/\"]")
    private SelenideElement navItemServices;
    @FindBy(xpath = NAV_BAR_NAV + "//div[@class=\"gh-nav-item gh-nav-item--solutions\"]")
    private SelenideElement navItemSolutions;
    @FindBy(xpath = NAV_BAR_NAV + "//a[@href=\"/vacancies/\"]")
    private SelenideElement navItemVacancies;
    @FindBy(xpath = NAV_BAR_NAV + "//a[@href=\"/blog/\"]")
    private SelenideElement navItemBlog;
    @FindBy(xpath = NAV_BAR_NAV + "//div[@class=\"gh-nav-item gh-nav-item--career\"]")
    private SelenideElement navItemCareer;
    @FindBy(xpath = NAV_BAR_NAV + "//div[@class=\"gh-nav-item gh-nav-item--about\"]")
    private SelenideElement navItemAbout;
    @FindBy(xpath = NAV_BAR_TOOLS + "//a[@class=\"gh-tools-lang\"]")
    private SelenideElement navToolsLang;

    @FindBy(xpath = NAV_BAR_TOOLS + "//a[@class=\"gh-tools-feedback write-to-us\"]")
    private SelenideElement navToolsFeedback;

    @Step("Проверить, что кнопка \"Написать нам\" видима и нажать на нее")
    public FeedbackModal showFeedbackModal() {
        navToolsFeedback
                .shouldBe(visible)
                .click();
        return page(FeedbackModal.class);
    }

    @Step("Проверить, что навигационный элемент \"О нас\" видим и навестись на него")
    public NavSubBoxAbout openNavSubBox() {
        navItemAbout
                .shouldBe(visible)
                .hover();
        return page(NavSubBoxAbout.class);
    }

}
