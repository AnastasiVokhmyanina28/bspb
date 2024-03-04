package pageObject.cardsPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.function.Predicate;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;


public class CardsPage {
    /**
     * фильтрация коллекции
     */
    public static final Predicate<SelenideElement> READY_TO_WORK = (SelenideElement input) -> {
        return !(input.getText().contains("заблокирована")
                || input.getText().contains("закрыта")
                || input.getText().contains("ждёт активации")
                || input.getText().contains("изготавливается"));
    };
    private final ElementsCollection cardsList = $$x("//li[contains(@class,'row-as-link cards')]/a");
    private final SelenideElement informationAboutTheOpenCard = $x("//div[@class='card-details hidden' and @style='display: block;']");
    private final SelenideElement modalLockWindow = $x("//div[@class='modal fade hide in']");
    private final SelenideElement blockingReason = $x("//input[@value='DEACTIVATION']");
    private final SelenideElement lockButton = $x("//button[@id = 'block-card']").as("Кнопка блокировки карты");
    private final SelenideElement confirmationButton = $x("//button[@id = 'confirm']").as("Кнопка подтверждения блокировки карты");

    String numberCard = "";

    /**
     * новую коллекцию передаем в метод рандомного выбора
     */
    public List<SelenideElement> filtredOn(Predicate<SelenideElement> filter) {
        return cardsList.asFixedIterable().stream().filter(filter).toList();
    }

    /**
     * Открыть нужную карту и получить номер карты
     */
    public CardsPage openTheCard(SelenideElement element) {
        element.click();
        numberCard = element.$x(".//span[@class='masked-number']").getText().substring(1);
        return this;
    }

    private String getNumberCard() {
        return informationAboutTheOpenCard.$x(".//span[@class='card-number ']").getText();
    }

    public CardsPage asserts() {
        assertThat(getNumberCard()).endsWith((numberCard));
        return this;
    }

    /**
     * блокировка карты
     */
    public CardsPage blockTheCard() {
        clickTheLockButton();
        selectSheReasonForBlocking();
        return this;
    }

    private void clickTheLockButton() {
        informationAboutTheOpenCard.$x(".//a[@class='card-block']").click();
        assertThat(modalLockWindow.isDisplayed()).as("Окно выбора причины не открыто").isTrue();
    }

    /**
     * выбрать причину блокировки  и клик по кнопке блокировки
     */
    private void selectSheReasonForBlocking() {
        blockingReason.click();
        lockButton.click();
        confirmationButton.click();
    }


}
