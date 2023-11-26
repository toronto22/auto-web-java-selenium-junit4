package bankproject.automation.helper.webdriver.remotedriver;

import bankproject.automation.helper.webdriver.DriverGenerator;
import org.openqa.selenium.WebDriver;

public class RemoteDriverFactory implements DriverGenerator {
    public WebDriver generateDriver(String browserName) {
        browserName = browserName.toLowerCase();
        return switch (browserName) {
            case "chrome" -> new RemoteDriverChrome().init();
            case "firefox" -> new RemoteDriverFirefox().init();
            default -> null;
        };
    }
}
