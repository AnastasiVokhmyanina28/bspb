package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class AutorizationPage {

    private final SelenideElement login = $(By.name("username")).as("Поле ввода логина");
    private final SelenideElement password = $(By.name("password")).as("Поле ввода пароля");
    private final SelenideElement buttonLogin = $(By.id("login-button")).as("Кнопка входа");
    private final SelenideElement text = $(By.id("otp-code-text")).as("Код подтверждения");


    public ConfirmationPage autorization() {
        buttonLogin.click();
        assertThat(text.isDisplayed()).as("При авторизации данные введены неверно").isTrue();
        return new ConfirmationPage();
    }


}
