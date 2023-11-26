package bankproject.feature.manager;

import bankproject.automation.WebHook;
import bankproject.automation.helper.junit.category.SmokeTests;
import bankproject.automation.page_object_model.AddCustomerPage;
import bankproject.automation.page_object_model.CustomerLoginPage;
import bankproject.automation.page_object_model.ManagerPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Feature("Adding Customer Tests")
@DisplayName("Adding Customer Tests")
@Category(SmokeTests.class)
public class AddingCustomerTest extends WebHook {
    AddCustomerPage addCustomerPage;

    String errorMessage = "Please fill out this field.";

    @Before
    public void classSetUp() {
        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.goTo();
        addCustomerPage = managerPage.goToAddCustomerPage();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Manager adds customer with valid customer information")
    public void managerAddsCustomerWithValidCustomerInformation() {
        String firstName = "W33";
        String lastName = "Haa";
        String postCode = "123";
        addCustomerPage.addCustomer(firstName, lastName, postCode);
        addCustomerPage.VerifyAlertCustomerIsAddedAndCloseTheAlert();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.goTo();
        String newCustomerName = firstName + " " + lastName;
        customerLoginPage.login(newCustomerName).verifyTheCustomerIsLoggedIn(newCustomerName);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Manager is unable to add customer with the empty first name")
    public void managerIsUnableToAddCustomerWithTheEmptyFirstName() {
        String firstName = "";
        String lastName = "Haa";
        String postCode = "123";
        addCustomerPage.addCustomer(firstName, lastName, postCode);
        addCustomerPage.verifyFirstNameValidationMessage(errorMessage);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Manager is unable to add customer with the empty last name")
    public void managerIsUnableToAddCustomerWithTheEmptyLastName() {
        String firstName = "W33";
        String lastName = "";
        String postCode = "123";
        addCustomerPage.addCustomer(firstName, lastName, postCode);
        addCustomerPage.verifyLastNameValidationMessage(errorMessage);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Manager is unable to add customer with the empty post code")
    @Flaky
    public void managerIsUnableToAddCustomerWithTheEmptyPostCode() {
        String firstName = "W33";
        String lastName = "Haa";
        String postCode = "";
        addCustomerPage.addCustomer(firstName, lastName, postCode);
        addCustomerPage.verifyPostCodeValidationMessage(errorMessage);
    }
}
