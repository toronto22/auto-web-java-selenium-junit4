package bankproject.automation.helper.webdriver.localdriver;

import bankproject.automation.helper.webdriver.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class LocalDriverChrome implements Driver {

    @Override
    public WebDriver init() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        if (config.IsHeadless) {
            chromeOptions.addArguments("--headless");
        }
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("no-sandbox");
        return new ChromeDriver(chromeOptions);
    }
}
