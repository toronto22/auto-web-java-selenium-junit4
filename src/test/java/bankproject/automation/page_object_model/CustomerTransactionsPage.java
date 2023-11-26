package bankproject.automation.page_object_model;

import bankproject.automation.helper.interaction.ui.Selenium;
import bankproject.automation.model.CustomerTransaction;
import bankproject.automation.model.WebUrl;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CustomerTransactionsPage extends CustomerPage {
    By resetBtn = By.xpath("//button[text()='Reset']");
    By transactionTable = By.tagName("table");

    public CustomerTransactionsPage(WebDriver driver) {
        this.driver = driver;
        this.url = WebUrl.CustomerTransaction;
        selenium = Selenium.Init(driver);
    }

    @Step("Reset")
    public void reset() {
        selenium.waitUntil(resetBtn).visible().click();
    }


    @Step("Get transaction information")
    public List<CustomerTransaction> getTransactionInformation() {
        List<CustomerTransaction> transactions = new ArrayList<>();
        List<List<String>> data = selenium.table(transactionTable).getTableData();
        for (List<String> row : data) {
            CustomerTransaction transaction = new CustomerTransaction();
            transaction.DateTime = row.get(0);
            transaction.Amount = Integer.parseInt(row.get(1));
            transaction.Type = row.get(2);

            transactions.add(transaction);
        }

        return transactions;
    }

    @Step("Verify number of transaction")
    public void verifyNumberOfTransactions(int expectedNumber) {
        int numberOfTransaction = getTransactionInformation().size();

        assertThat(expectedNumber, is(numberOfTransaction));
    }

    @Step("Verify last customer transaction")
    public void verifyLastCustomerTransaction(int amount, String type) {
        List<CustomerTransaction> transactions = getTransactionInformation();
        CustomerTransaction lastTransaction = transactions.get(transactions.size() - 1);

        assertThat(lastTransaction.Amount, is(amount));
        assertThat(lastTransaction.Type, is(type));
    }
}
