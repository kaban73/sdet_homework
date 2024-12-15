package lection_6;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class FeedbackModal {
    private final String FEEDBACK_MODAL = "//*[@class=\"fmo-parent\"]//*[@class=\"fb-modal-default\"]";
    @FindBy(xpath = FEEDBACK_MODAL)
    private SelenideElement feedbackWindow;
    @FindBy(xpath = FEEDBACK_MODAL + "//input[@name='form_text_72']")
    private SelenideElement inputNameOrOrganization;

    public FeedbackModal checkModalWindowVisible() {
        feedbackWindow.shouldBe(visible);
        return this;
    }
    public FeedbackModal checkInputNameOrOrganization() {
        inputNameOrOrganization.shouldBe(visible);
        return this;
    }
}
