package bankproject.automation.helper.webdriver;

import org.openqa.selenium.WebDriver;

public interface DriverGenerator {
    WebDriver generateDriver(String browserName);
}
