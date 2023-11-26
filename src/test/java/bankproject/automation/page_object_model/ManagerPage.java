package bankproject.automation.page_object_model;

import bankproject.automation.helper.interaction.ui.Selenium;
import bankproject.automation.model.WebUrl;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ManagerPage extends BasePage {
    By addCustomerBtn = By.xpath("//*[@ng-class='btnClass1']");

    public ManagerPage(WebDriver driver) {
        this.driver = driver;
        this.url = WebUrl.Manager;
        selenium = Selenium.Init(driver);
    }


    @Step("Go to add customer page")
    public AddCustomerPage goToAddCustomerPage() {
        selenium.waitUntil(addCustomerBtn).visible().click();
        return new AddCustomerPage(driver);
    }
}
