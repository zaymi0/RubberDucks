import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

@Epic("Selenide")
@Feature("Feature")
@Listeners({SoftAsserts.class, ScreenshotListener.class})
public class RubberDucksSelenideTest {
@BeforeMethod
public void setup() {
    String browserName = System.getProperty("browser", "edge");
    Manager.setupBrowser(browserName);
    String platformName = System.getProperty("platform", "WIN10");
    Manager.setupPlatform(platformName);
}
@AfterMethod
public void teardown(ITestResult testResult) {
//    if (testResult.getStatus() == ITestResult.FAILURE) {
//        File screenshot = Selenide.screenshot(OutputType.FILE);
//        try {
//            Allure.addAttachment(testResult.getMethod().getMethodName(),new FileInputStream(screenshot));
//            ReportPortal.emitLog(testResult.getMethod().getMethodName(), "ERROR",
//                    Calendar.getInstance().getTime(),screenshot);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
    closeWebDriver();
}

    @Description("Тест авторизации")
    @Story("Логин")
    @Test
    public void accountLogin() {
        LoginPage.attemptLogin("mihazx007@gmail.com", "QWERTY");
        HomePage.validateSuccessMassageText("You are now logged in as Mi Za.");
    }
    @Description("Тест на корректное отображение приветственной надписи после успешной авторизации")
    @Story("Логин")
    @Test
    public void displayLineAfterLogin() {
        LoginPage.attemptLogin("mihazx007@gmail.com", "QWERTY");
        HomePage.validateSuccessMassageText("You are now logged in as Mi Za.");
        HomePage.successMassageIsVisible();
    }
    @Description("Тест на добавление товара в корзину.")
    @Story("Корзин")
    @Test
    public void addingItemToCart() {
        CatalogPage.theGreenDuckInTheMostPopularBlockClick();
        ProductPage.enteringTheQuantityOfGoods("1");
        ProductPage.addToCartButtonClick();
        PageHead.waitToBeAddedToCart("1");
        PageHead.theItemsInTheCartCorrespondToTheExpectedOnes("1");
    }
    @Description("Тест на превышение количества товара в корзине над складским количеством.")
    @Story("Корзина")
    @Test
    public void addingMoreItemsToTheCartThanAreInStock() {
        CatalogPage.theGreenDuckInTheMostPopularBlockClick();
        ProductPage.enteringTheQuantityOfGoods(String.valueOf(ProductPage.getStockStatusInteger() + 1));
        ProductPage.addToCartButtonClick();
        PageHead.waitToBeAddedToCart();
        Assert.assertTrue(PageHead.getAreThereNoMoreItemsInTheCartThanInStock(),
                "There are more items in the cart than are in stock.");
    }

    @Description("Тест на корректное отображение блока 'недавно просмотренные'")
    @Story("Недавно просмотренные")
    @Test
    public void addingAProductToRecentlyViewed() {
        CatalogPage.theGreenDuckInTheMostPopularBlockClick();
        String titleOfTheSelectedProduct = title();
        RecentlyViewedPage.productFromTheRecentlyViewedPageClick();
        Assert.assertTrue(PageHead.thePageTitleMustMatchWhatIsExpected(titleOfTheSelectedProduct));
    }
}
