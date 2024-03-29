package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pageObject.toolBar.Header;
import pageObject.toolBar.Navbar;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PaymentsPage implements Header, Navbar {

    private final SelenideElement leftMenu = $(By.id("payments-left-menu"));
    private final SelenideElement history = $x("//*[@class = 'payment-menu-icon history']");
    private final SelenideElement favorites = $x("//*[@class = 'payment-menu-icon favorites']");
    private final SelenideElement transfers = $x("//*[@class = 'payment-menu-icon transfers']");
    private final ElementsCollection paymentElements = $$(By.className("vendor-type"));


    public HistoryOfOperationsInTheSystemPage openHistoryPayments() {
        history.click();
        return new HistoryOfOperationsInTheSystemPage();
    }

    public PaymentsPage checkPageActivity(){
        assertThat(leftMenu.isDisplayed()).as("Страница 'Платежи и переводы не открыта'").isTrue();
        return this;
    }

}
