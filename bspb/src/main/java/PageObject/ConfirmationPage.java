package PageObject;

import PageObject.ToolBar.Header;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmationPage implements Header {

    public final SelenideElement loginButton = $(By.id("login-otp-button")).as("Кнопка входа");

    public HomePage logIn() {
        loginButton.click();
        checkTheButtonDisplay();
        return new HomePage();
    }
}
