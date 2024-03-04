import org.junit.jupiter.api.Test;
import pageObject.autorizationPage.AutorizationPage;
import pageObject.cardsPage.CardsPage;
import pageObject.toolBar.Header;
import pageObject.toolBar.Navbar;
import servise.chromeDriver.BaseClass;
import utils.RandomSelection;

public class CardUnlockingTest extends BaseClass implements Navbar, Header {

    @Test
    public void CardBlocking() {

        AutorizationPage loginPage = openLoginPage();
        loginPage.autorization();

        CardsPage cardsPage = openTheCardsTab();

        cardsPage
                .openTheCard(RandomSelection.randomize(cardsPage.filtredOn(CardsPage.READY_TO_WORK))) //определенная карта
                .asserts()
                .blockTheCard();

    }
    /**добавить проверку, что карта заблокирована*/

}
