package pageObject.autorizationPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pageObject.HomePage;
import pageObject.toolBar.Header;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class AccessCodeBlock implements Header {

    public final SelenideElement loginButton = $(By.id("login-otp-button")).as("Кнопка входа");
    private final SelenideElement text = $(By.id("otp-code-text")).as("Код подтверждения");

    public HomePage logIn() {
        loginButton.click();
        checkTheButtonDisplay();
        return new HomePage();
    }

    public AccessCodeBlock dataVerification() {
        assertThat(text.isDisplayed()).as("При авторизации данные введены неверно").isTrue();
        return this;
    }

}
