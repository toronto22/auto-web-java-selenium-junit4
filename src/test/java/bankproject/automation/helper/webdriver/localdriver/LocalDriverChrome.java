package bankproject.automation.helper.webdriver.localdriver;

import bankproject.automation.helper.webdriver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static bankproject.automation.model.DriverPath.CHROME_DRIVER_PATH;


public class LocalDriverChrome implements Driver {

    @Override
    public WebDriver init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        if (config.IsHeadless) {
            chromeOptions.addArguments("--headless");
        }
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("no-sandbox");
        return new ChromeDriver(chromeOptions);
    }
}
