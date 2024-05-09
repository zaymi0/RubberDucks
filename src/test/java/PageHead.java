import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class PageHead {
    private static By numberOfItemsInCartLockator = By.cssSelector("span.quantity");
    @Step("Проверка на наличие в корзине большего количества товара, чем есть на складе")
    public static void waitToBeAddedToCart() {
        $(numberOfItemsInCartLockator).shouldHave(text(String.valueOf(ProductPage.getStockStatusInteger() + 1)));
    }
    @Step("Проверка наличия в корзине запланированного количества товаров")
    public static void waitToBeAddedToCart(String numberOfGoods) {
        $(numberOfItemsInCartLockator).shouldHave(text(numberOfGoods));
    }
    @Step("Проверяет превышение складского количества товара в корзине")
    public static boolean getAreThereNoMoreItemsInTheCartThanInStock() {
        return ProductPage.getStockStatusInteger() >= Integer.parseInt($(numberOfItemsInCartLockator).getText());
    }
    @Step("Возврашает количество товаров в корзине")
    public static String getNumberOfItemsInCart() {
        return $(numberOfItemsInCartLockator).getText();
    }
    @Step("Сравнивает количество товаров в корзине с ожидаемым")
    public static void theItemsInTheCartCorrespondToTheExpectedOnes(String expected) {
        $(numberOfItemsInCartLockator).shouldHave(text(expected));
    }
    @Step("Сравнивает заголовок страницы с ожидаемым")
    public static boolean thePageTitleMustMatchWhatIsExpected(String expectedTitle) {
        return title().equalsIgnoreCase(expectedTitle);
    }

}