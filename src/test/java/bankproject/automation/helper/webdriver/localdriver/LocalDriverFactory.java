package bankproject.automation.helper.webdriver.localdriver;

import bankproject.automation.helper.webdriver.DriverGenerator;
import org.openqa.selenium.WebDriver;

public class LocalDriverFactory implements DriverGenerator {
    public WebDriver generateDriver(String browserName) {
        browserName = browserName.toLowerCase();
        return switch (browserName) {
            case "chrome" -> new LocalDriverChrome().init();
            case "firefox" -> new LocalDriverFirefox().init();
            default -> null;
        };
    }
}
