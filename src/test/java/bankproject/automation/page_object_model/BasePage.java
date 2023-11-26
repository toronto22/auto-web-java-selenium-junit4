package bankproject.automation.page_object_model;

import bankproject.automation.helper.interaction.ui.Selenium;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected String url;
    protected Selenium selenium;

    public void goTo() {
        driver.navigate().to(url);
    }
}
