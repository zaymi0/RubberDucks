import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    private static By theGreenDuckInTheMostPopularBlockLockator = By.cssSelector("#box-most-popular [href$='-p-2']");
    @Step("Клик по зеленой утке")
    public static void theGreenDuckInTheMostPopularBlockClick() {
        $(theGreenDuckInTheMostPopularBlockLockator).click();
    }
}

