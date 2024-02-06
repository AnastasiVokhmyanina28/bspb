package pageObject.autorizationPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPasswordBlock {

    private final SelenideElement login = $(By.name("username")).as("Поле ввода логина");
    private final SelenideElement password = $(By.name("password")).as("Поле ввода пароля");
    private final SelenideElement buttonLogin = $(By.id("login-button")).as("Кнопка входа");

    public AccessCodeBlock inputLogPass(String loginValue, String passwordValue) {
        login.clear();
        login.sendKeys(loginValue);
        password.clear();
        password.sendKeys(passwordValue);
        buttonLogin.click();
        return new AccessCodeBlock();
    }

}
