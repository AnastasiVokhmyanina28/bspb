import org.junit.jupiter.api.Test;
import pageObject.autorizationPage.AutorizationPage;
import servise.chromeDriver.BaseClass;

public class AutorizationTest extends BaseClass {

    @Test
    public void autorization() {

        AutorizationPage autorization = openLoginPage();

        autorization.autorization();

    }
}
