package lection_6.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lection_6.elements.NavBar;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    private static final String MAIN_PAGE_H1 = "//div[@class=\"page-default\"]//h1";
    private static final String TEXT_MAIN_PAGE_1_RUS = "Создаём программное обеспечение для роста вашего бизнеса";
    private static final String NAV_BAR_DIV = "//div[div[contains(@class, \"gh-logo\")]" +
            "and div[contains(@class, 'gh-nav')]" +
            "and div[contains(@class, 'gh-tools')]]";
    @FindBy(xpath = MAIN_PAGE_H1)
    private SelenideElement mainPageH1;
    @FindBy(xpath = NAV_BAR_DIV)
    private SelenideElement navBar;
    @Step("Проверить, что элемент h1 содержит текст \"Создаём программное обеспечение для роста вашего бизнеса\"")
    public MainPage checkMainPage() {
        mainPageH1.
                shouldBe(visible)
                .shouldHave(text(TEXT_MAIN_PAGE_1_RUS));
        return this;
    }
    @Step("Проверить, что navBar виден на странице")
    public NavBar checkNavBar() {
        navBar.shouldBe(visible);
        return page(NavBar.class);
    }
}
