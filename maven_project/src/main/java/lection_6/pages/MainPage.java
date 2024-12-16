package lection_6.pages;

import com.codeborne.selenide.SelenideElement;
import lection_6.elements.NavBar;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    private static final String MAIN_PAGE_DIV = "//div[@class=\"page-default\"]";
    private static final String NAV_BAR_DIV = "//div[div[contains(@class, \"gh-logo\")]" +
            "and div[contains(@class, 'gh-nav')]" +
            "and div[contains(@class, 'gh-tools')]]";
    @FindBy(xpath = MAIN_PAGE_DIV)
    private SelenideElement mainPageLayout;
    @FindBy(xpath = NAV_BAR_DIV)
    private SelenideElement navBar;
    private MainPage checkMainPage() {
        mainPageLayout.shouldBe(visible);
        return this;
    }

    public NavBar checkNavBar() {
        checkMainPage();

        navBar.shouldBe(visible);
        return page(NavBar.class);
    }
}
