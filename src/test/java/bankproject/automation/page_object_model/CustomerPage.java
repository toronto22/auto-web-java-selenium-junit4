package bankproject.automation.page_object_model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CustomerPage extends BasePage {
    By logoutBtn = By.className("logout");

    @Step("user logout")
    public void logout() {
        selenium.waitUntil(logoutBtn).visible().click();

        new CustomerLoginPage(driver);
    }
}
