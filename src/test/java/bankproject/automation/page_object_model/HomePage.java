package bankproject.automation.page_object_model;

import bankproject.automation.helper.interaction.ui.Selenium;
import bankproject.automation.model.WebUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    By customerLoginBtn = By.xpath("//button[text()='Customer Login']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.url = WebUrl.Home;
        this.selenium = Selenium.Init(driver);
    }

    public CustomerLoginPage customerLogin() {
        selenium.waitUntil(customerLoginBtn).visible().click();

        return new CustomerLoginPage(driver);
    }
}
