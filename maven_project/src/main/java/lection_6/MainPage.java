package lection_6;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    @FindBy(xpath = "//a[@data-gclick='showModalFeedback']")
    private SelenideElement feedbackButton;

    public FeedbackModal showFeedbackModal() {
        feedbackButton
                .shouldBe(visible)
                .click();
        return page(FeedbackModal.class);
    }
}
