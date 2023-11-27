package bankproject.automation.helper.webdriver.localdriver;

import bankproject.automation.helper.webdriver.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class LocalDriverFirefox implements Driver {
    @Override
    public WebDriver init() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        if (config.IsHeadless) {
            firefoxOptions.addArguments("--headless");
        }

        return new FirefoxDriver(firefoxOptions);
    }
}
