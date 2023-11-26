package bankproject.automation.helper.webdriver;

import bankproject.automation.helper.webdriver.localdriver.LocalDriverFactory;
import bankproject.automation.helper.webdriver.remotedriver.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public static WebDriver generateDriver(String browserName, boolean isGrid) {
        DriverGenerator driverFactory;

        if (isGrid) {
            driverFactory = new RemoteDriverFactory();
        } else {
            driverFactory = new LocalDriverFactory();
        }

        return driverFactory.generateDriver(browserName);
    }

}
