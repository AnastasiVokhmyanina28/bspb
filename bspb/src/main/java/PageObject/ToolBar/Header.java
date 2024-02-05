package PageObject.ToolBar;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public interface Header {
    SelenideElement logoutButton = $(By.className("icon-door"));


    default void checkTheButtonDisplay() {
        assertThat(logoutButton.isDisplayed()).as("Пользователь не авторизован").isTrue();
    }
}
