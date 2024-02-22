import data.DateCalculation;
import org.junit.jupiter.api.Test;
import pageObject.autorizationPage.AutorizationPage;
import pageObject.toolBar.Header;
import pageObject.toolBar.Navbar;
import servise.chromeDriver.BaseClass;


public class HistoryOfOperationsInTheSystemTest extends BaseClass implements Header, Navbar {

    @Test
    public void setADate() {
        AutorizationPage autorization = openLoginPage();
        autorization.autorization();

        openThePaymentsTab()
                .checkPageActivity()
                .openHistoryPayments()
                .checkPageActivityHistory()
                .selectBeginningOfPeriod(DateCalculation.calculateTheDate(100))
                .selectEndOfPeriod(DateCalculation.calculateTheDate(0))
                .downloadButtonClick()
                .checkDates(DateCalculation.calculateTheDate(100), DateCalculation.calculateTheDate(0));
    }

}
