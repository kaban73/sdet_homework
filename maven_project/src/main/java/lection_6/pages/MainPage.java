package lection_6.pages;

import com.codeborne.selenide.SelenideElement;
import lection_6.FeedbackModal;
import lection_6.NavSubBox;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    @FindBy(xpath = "//a[@data-gclick='showModalFeedback']")
    private SelenideElement feedbackButton;
    @FindBy(xpath = "//div[@class=\"gh-nav-item gh-nav-item--about\"]")
    private SelenideElement navItemAbout;

    public FeedbackModal showFeedbackModal() {
        feedbackButton
                .shouldBe(visible)
                .click();
        return page(FeedbackModal.class);
    }

    public NavSubBox openNavSubBox() {
        navItemAbout
                .shouldBe(visible)
                .hover();
        return page(NavSubBox.class);
    }
}
