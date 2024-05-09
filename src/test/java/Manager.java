import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

public class Manager {
    public static void setupBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome" -> Configuration.browser = "chrome";
            case "firefox" -> Configuration.browser = "firefox";
            case "safari" -> Configuration.browser = "safari";
            case "edge" -> Configuration.browser = "edge";
        }
    }
    public static void setupPlatform(String platformName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (platformName.toLowerCase()) {
            case "win" -> capabilities.setPlatform(Platform.WIN10);
            case "linux" -> capabilities.setPlatform(Platform.LINUX);
            case "mac" -> capabilities.setPlatform(Platform.MAC);
        }
        Configuration.remote = "http://192.168.100.124:4444/wd/hub";
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://litecart.stqa.ru/en/";
        Configuration.browserSize = "1920x1080";
        open(Configuration.baseUrl);
    }
}
