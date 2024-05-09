import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static By loinInputLocator = By.name("email");
    private static By passwordInputLocator = By.name("password");
    private static By loginButtonLocator = By.name("login");
    @Step("Вход в аккаунт")
    public static void attemptLogin (String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickLoginButton();
    }
    @Step("Ввод почты")
    public static void inputEmail (String email) {
        $(loinInputLocator).sendKeys(email);
    }
    @Step("Ввод пароля")
    public static void inputPassword (String password) {
        $(passwordInputLocator).sendKeys(password);
    }
    @Step("Клик на кнопку Login")
    public static void clickLoginButton () {
        $(loginButtonLocator).click();
    }
}
