import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkTest {

    @BeforeClass
    public void init() {
        Configuration.browser = "edge";
        Configuration.baseUrl = "https://web.telegram.org/a/";
    }

    /**
     * Для тестирования был выбран сайт https://web.telegram.org/a/
     * Сайт тестировался по трем сценариям:
     * 1. Успешная авторизация на сайте
     *      - Попадаем на сайт
     *      - Выбираем "Продолжить на русском"
     *      - Нажимаем "Вход по номеру телефона"
     *      - Затем вводим верный номер телефона
     *      - Нажимаем кнопку "Далее"
     *      - Затем проверяем, что мы на странице, на которой нужно ввести код
     *      (Так как для входа в телеграм нужны реальные данные, то за "успешную авторизацию" будем считать попадание на страницу с вводом кода для входа в аккаунт)
     * 2. Неуспешная авторизация на сайте
     *      - Попадаем на сайт
     *      - Выбираем "Продолжить на русском"
     *      - Нажимаем "Вход по номеру телефона"
     *      - Затем вводим неверный номер телефона
     *      - Нажимаем кнопку "Далее"
     *      - Затем проверяем, что в форме ввода номера появилась надпись "Invalid phone number"
     * 3. Успешная авторизация на сайте через номер другой страны
     *      - Попадаем на сайт
     *      - Нажимаем "Log in by phone number"
     *      - Затем выбираем любую страну
     *      - Нажимаем кнопку "Next"
     *      - Затем проверяем, что мы на странице, на которой нужно ввести код
     */

    private static final String H1_ENG = "Log in to Telegram by QR Code";
    private static final String H1_RUS = "Быстрый вход по QR-коду";
    private static final String LOG_IN_ENG = "Log in by phone Number";
    private static final String LOG_IN_RUS = "Вход по номеру телефона";
    private static final String CHANGE_LANG_BTN_TEXT = "Продолжить на русском";
    private static final String INPUT_ID = "sign-in-phone-number";
    private static final String INPUT_NUMBER = "79876886998";
    private static final String INPUT_ARGENTINA_NUMBER = "543511234567";
    private static final String INPUT_WRONG_NUMBER = "99999999999999";
    private static final String INVALID_PHONE_NUMBER = "Invalid phone number.";
    private static final String NEXT_BTN_ENG = "Next";
    private static final String NEXT_BTN_RUS = "Далее";

    public void init_changeLang_logInByPhone() {
        SelenideElement h1_element = $(By.cssSelector("h1"));
        SelenideElement logInButton = $x("//button[text()='" + LOG_IN_ENG + "']");
        SelenideElement changeLangButton = $x("//button[text()='" + CHANGE_LANG_BTN_TEXT + "']");

        h1_element
                .shouldBe(visible)
                .shouldHave(text(H1_ENG));
        logInButton.shouldBe(visible);
        changeLangButton.shouldBe(visible);

        changeLangButton.click();

        h1_element.shouldHave(text(H1_RUS));
        logInButton = $x("//button[text()='" + LOG_IN_RUS + "']");
        logInButton.
                shouldBe(visible)
                .click();
    }

    @Test(groups = "homework")
    public void test_auth_success() {
        open(Configuration.baseUrl);

        init_changeLang_logInByPhone();

        SelenideElement input = $(By.id(INPUT_ID));
        SelenideElement next_button = $(By.cssSelector("button[type=\"submit\"]"));

        input.shouldBe(visible).click();
        next_button.shouldNotBe(exist);

        input.type(INPUT_NUMBER);

        next_button = $(By.cssSelector("button[type=\"submit\"]"));
        next_button.shouldBe(visible).shouldBe(text(NEXT_BTN_RUS));
        next_button.click();

        $x("//*[@id=\"monkey\"]").shouldBe(visible);
        sleep(1500);
    }

    @Test(groups = "homework")
    public void test_auth_unsuccess() {
        open(Configuration.baseUrl);

        init_changeLang_logInByPhone();

        SelenideElement input = $(By.id(INPUT_ID));
        SelenideElement next_button = $(By.cssSelector("button[type=\"submit\"]"));

        input.shouldBe(visible).click();
        next_button.shouldNotBe(exist);

        input.type(INPUT_WRONG_NUMBER);

        next_button = $(By.cssSelector("button[type=\"submit\"]"));
        next_button.shouldBe(visible).shouldBe(text(NEXT_BTN_RUS));
        next_button.click();

        $(By.xpath("//label[@for=\"sign-in-phone-number\"]"))
                .shouldBe(visible)
                .shouldBe(text(INVALID_PHONE_NUMBER));
        sleep(1500);
    }

    @Test(groups = "homework")
    public void test_auth_success_change_country() {
        open(Configuration.baseUrl);

        SelenideElement h1_element = $(By.cssSelector("h1"));
        SelenideElement logInButton = $x("//button[text()='" + LOG_IN_ENG + "']");

        h1_element
                .shouldBe(visible)
                .shouldHave(text(H1_ENG));
        logInButton
                .shouldBe(visible)
                .click();

        SelenideElement countryList = $(By.id("sign-in-phone-code"));
        SelenideElement input = $(By.id(INPUT_ID));
        SelenideElement next_button = $(By.cssSelector("button[type=\"submit\"]"));

        countryList.shouldBe(visible).click();
        SelenideElement argentinaItem = $x("//span[text()='Argentina']");
        argentinaItem.click();

        input.shouldBe(visible).click();
        next_button.shouldNotBe(exist);

        input.type(INPUT_ARGENTINA_NUMBER);

        next_button = $(By.cssSelector("button[type=\"submit\"]"));
        next_button.shouldBe(visible).shouldBe(text(NEXT_BTN_ENG));
        next_button.click();

        sleep(5000);
        $x("//*[@id=\"monkey\"]").shouldBe(visible);
        sleep(1500);
    }
}
