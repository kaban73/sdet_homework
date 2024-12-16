package lection_6.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class FeedbackModal {
    private final String FEEDBACK_MODAL = "//*[@class=\"fmo-parent\"]//*[@class=\"fb-modal-default\"]";
    @FindBy(xpath = FEEDBACK_MODAL)
    private SelenideElement feedbackWindow;
    @FindBy(xpath = FEEDBACK_MODAL + "//input[@name='form_text_72']")
    private SelenideElement inputNameOrOrganization;
    @Step("Проверить, что модальное окно видимо")
    private FeedbackModal checkModalWindowVisible() {
        feedbackWindow.shouldBe(visible);
        return this;
    }
    @Step("Проверить, что поле для ввода \"Имя или организация\" видимо")
    public FeedbackModal checkInputNameOrOrganization() {
        checkInputNameOrOrganization();

        inputNameOrOrganization.shouldBe(visible);
        return this;
    }
}
