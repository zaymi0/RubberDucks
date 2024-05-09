import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private static By stockStatusLockator = By.cssSelector("div.stock-available>span.value");
    private static By fieldForEnteringTheQuantityOfGoodsLockator = By.cssSelector("input[type='number']");
    private static By addToCartButtonLockator = By.cssSelector("button[value='Add To Cart']");
    @Step("Вводим количество товара")
    public static void enteringTheQuantityOfGoods(String numberOfGoods) {
        $(fieldForEnteringTheQuantityOfGoodsLockator).clear();
        $(fieldForEnteringTheQuantityOfGoodsLockator).sendKeys(numberOfGoods);
    }
    @Step("Кликаем по кнопке 'add to cart'")
    public static void addToCartButtonClick() {
        $(addToCartButtonLockator).click();
    }
    @Step("Возвращает количество товаров на складе")
    public static int getStockStatusInteger() {
        String[] stockStatus = $(By.cssSelector("div.stock-available>span.value")).getText().split(" ");
        return Integer.parseInt(stockStatus[0]);
    }

}
