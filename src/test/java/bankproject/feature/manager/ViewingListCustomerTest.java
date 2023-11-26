package bankproject.feature.manager;

import bankproject.automation.WebHook;
import bankproject.automation.model.BankConstants;
import bankproject.automation.model.Customer;
import bankproject.automation.page_object_model.AddCustomerPage;
import bankproject.automation.page_object_model.ListCustomersPage;
import bankproject.automation.page_object_model.OpenAccountPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

@Feature("Viewing List Customer Tests")
@DisplayName("Viewing List Customer Tests")
public class ViewingListCustomerTest extends WebHook {
    ListCustomersPage listCustomersPage;

    int numberOfItem = 5;

    @Before
    public void classSetUp() {
        listCustomersPage = new ListCustomersPage(driver);
        listCustomersPage.goTo();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Manager view list customer table")
    public void managerViewListCustomerTable() {
        listCustomersPage.goTo();
        listCustomersPage.verifyListCustomerTable(numberOfItem);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Manager create new customer")
    public void managerCreateNewCustomer() {
        Customer customer = new Customer("W33", "Haa", "1234");

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.goTo();
        addCustomerPage.addCustomer(customer);
        addCustomerPage.VerifyAlertCustomerIsAddedAndCloseTheAlert();

        listCustomersPage.goTo();
        listCustomersPage.verifyListCustomerTable(numberOfItem + 1);

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.goTo();
        String customerName = customer.FirstName + " " + customer.LastName;
        openAccountPage.openAccount(customerName, BankConstants.DefaultCurrency);
        String accountNumbers = openAccountPage.getAccountNumberIsCreatedInAlert();
        customer.AccountNumbers = new ArrayList<>();
        customer.AccountNumbers.add(accountNumbers);
        openAccountPage.closeAlert();

        listCustomersPage.goTo();
        listCustomersPage.verifyCustomerIsExisted(customer);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Manager delete the customer")
    public void managerDeleteTheCustomer() {

        Customer customer = new Customer("W33", "Haa", "1234");

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.goTo();
        addCustomerPage.addCustomer(customer);
        addCustomerPage.VerifyAlertCustomerIsAddedAndCloseTheAlert();

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.goTo();
        String customerName = customer.FirstName + " " + customer.LastName;
        openAccountPage.openAccount(customerName, BankConstants.DefaultCurrency);
        String accountNumbers = openAccountPage.getAccountNumberIsCreatedInAlert();
        openAccountPage.closeAlert();

        listCustomersPage.goTo();
        listCustomersPage.deleteCustomer(accountNumbers);
        listCustomersPage.verifyListCustomerTable(numberOfItem);
    }
}
