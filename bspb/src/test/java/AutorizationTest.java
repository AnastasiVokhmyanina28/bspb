import PageObject.AutorizationPage;
import PageObject.ConfirmationPage;
import Servise.ChromeDriver.BaseClass;
import org.junit.jupiter.api.Test;

public class AutorizationTest extends BaseClass {

    @Test
    public void autorization(){

        AutorizationPage autorization = openLoginPage();

        ConfirmationPage confirmationPage = autorization.autorization();
        confirmationPage.logIn();
    }
}
