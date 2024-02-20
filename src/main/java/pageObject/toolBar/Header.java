package pageObject.toolBar;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public interface Header {
    SelenideElement logoutButton = $(By.id("logout-button")).as("Выход с сайта");
    SelenideElement settingsButton = $(By.id("settings-button")).as("Настройки");

    default void checkTheButtonDisplay() {
        assertThat(logoutButton.isDisplayed()).as("Пользователь не авторизован").isTrue();
    }
}
