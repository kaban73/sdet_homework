package lection_6.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class CareerPage {
    private static final String CAREER_PAGE_H1 = "//div[@class=\"page-default\"]//h1";
    private static final String TEXT_CAREER_PAGE_1_RUS = "Работа в SimbirSoft";
    private static final String NAV_BAR_DIV = "//div[div[contains(@class, \"gh-logo\")]" +
            "and div[contains(@class, 'gh-nav')]" +
            "and div[contains(@class, 'gh-tools')]]";
    @FindBy(xpath = CAREER_PAGE_H1)
    private SelenideElement careerPageH1;
    @FindBy(xpath = NAV_BAR_DIV)
    private SelenideElement navBar;

    @Step("Проверить, что элемент h1 содержит текст \"Работа в SimbirSoft\"")
    public CareerPage checkCareerPage() {
        careerPageH1
                .shouldBe(visible)
                .shouldHave(text(TEXT_CAREER_PAGE_1_RUS));
        return this;
    }
}
