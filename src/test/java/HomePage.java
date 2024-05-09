import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private static By successMassageLocator = By.cssSelector(".notice.success");
    private static By errorMassageLocator = By.cssSelector(".notice.errors");
    @Step("Возвращает текст сообщения об успешной авторизации")
    public static String getSuccessMassageText() {
        return $(successMassageLocator).getText();
    }
    @Step("Возвращает текст сообщения об ошибке авторизации")
    public static String getErrorMassageText() {
        return $(errorMassageLocator).getText();
    }
    @Step("Проверка видимости сообщения об ошибке авторизации")
    public static boolean isErrorMassageIsVisible() {
        return $(errorMassageLocator).isDisplayed();
    }
    @Step("Праверка текста сообщения об успешной авторизации")
    public static void validateSuccessMassageText(String successfulLoginText) {
        $(successMassageLocator).shouldHave(text(successfulLoginText));
    }
    @Step("Проверка видимости сообщения об успешной авторизации")
    public static void successMassageIsVisible() {
        $(successMassageLocator).shouldBe(visible);
    }


}
