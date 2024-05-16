import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class RecentlyViewedPage {
    private static By productFromTheRecentlyViewedPageLockator = By.cssSelector("#box-recently-viewed-products li:nth-child(1)");
    @Step("Кликаем на первый товар из блока 'недано просмотренные'")
    public static void productFromTheRecentlyViewedPageClick() {
        $(productFromTheRecentlyViewedPageLockator).click();
    }

}
