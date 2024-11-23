import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;

public class SelenideExampleTests {
    private static String LOGIN;
    private static final String SIGN_IN_BUTTON_TEXT = "Войти";
    private static final String AUTH_VK_URL = "https://id.vk.com/auth";
    @BeforeClass
    public void setupBrowser() {
        Configuration.browser = "edge";
    }
    @BeforeClass
    public void setLOGIN() {
        LOGIN = "login@yandex.ru";
    }
    @BeforeClass
    public void init() {
        Configuration.baseUrl = "https://vk.com/";
    }
    @Test
    public void test1() {
        open(Configuration.baseUrl);
        $(By.cssSelector("div[id=\"index_login\"]"))
                .shouldBe(visible);
        $(By.cssSelector("button[class=\"FlatButton FlatButton--positive FlatButton--size-l FlatButton--wide VkIdForm__button VkIdForm__signUpButton\"]"))
                .shouldBe(visible)
                .shouldHave(text("Создать аккаунт"))
                .click();
        $(By.cssSelector("div[class=\"vkc__AuthRoot__contentIn\"]"))
                .shouldBe(visible)
                .shouldHave(text("Введите номер"));
        sleep(5000);
    }

    @Test
    public void test2() {
        open(Configuration.baseUrl);
        SelenideElement inputLogin = $x("//*[@id='index_email']");
        SelenideElement signInButton = $(By.xpath("//*[contains(@class, 'VkIdForm__signInButton')]"));

        inputLogin.shouldBe(visible).click();
        signInButton.shouldBe(visible).shouldHave(text(SIGN_IN_BUTTON_TEXT));

        inputLogin.type(LOGIN);
        signInButton.click();

        webdriver().shouldHave(urlStartingWith(AUTH_VK_URL));

        sleep(5000);
    }
}
