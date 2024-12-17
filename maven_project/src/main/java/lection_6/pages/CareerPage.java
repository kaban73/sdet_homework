package lection_6.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class CareerPage {
    private static final String PAGE_DIV = "//div[@class=\"page-default\"]";
    private static final String CAREER_PAGE_H1 = PAGE_DIV + "//h1";
    private static final String TEXT_CAREER_PAGE_1_RUS = "Работа в SimbirSoft";
    private static final String NAV_BAR_DIV = "//div[div[contains(@class, \"gh-logo\")]" +
            "and div[contains(@class, 'gh-nav')]" +
            "and div[contains(@class, 'gh-tools')]]";
    @FindBy(xpath = CAREER_PAGE_H1)
    private SelenideElement careerPageH1;
    @FindBy(xpath = NAV_BAR_DIV)
    private SelenideElement navBar;
    @FindBy(xpath = PAGE_DIV + "//div[@class=\"ac-item\"]//span[contains(text(), \"график работы\")]")
    private SelenideElement accordionItemFirst;
    @FindBy(xpath = PAGE_DIV + "//h3[contains(text(), 'Вопрос-ответ')]")
    private SelenideElement accordionHeader;

    @Step("Проверить, что элемент h1 содержит текст \"Работа в SimbirSoft\"")
    public CareerPage checkCareerPage() {
        careerPageH1
                .shouldBe(visible)
                .shouldHave(text(TEXT_CAREER_PAGE_1_RUS));
        return this;
    }
    @Step("Проверить, что элемент h3 существует, доскроллить до него и проверить видим ли он")
    public CareerPage scrollToAccordionItemFirst() {
        accordionHeader
                .shouldBe(exist)
                .scrollTo()
                .shouldBe(visible);
        return this;
    }
    @Step("Проверить, что первый элемент аккордиона существует и нажать на него")
    public CareerPage clickAccordionItemFirst() {
        accordionItemFirst
                .shouldBe(visible)
                .click();
        return this;
    }
}
