package bankproject.automation.model;

public class Account {
    public String CustomerName;
    public String AccountNumber;
    public int Balance;
    public String Currency;
    public Account(String customerName, String accountNumber, int balance, String currency) {
        CustomerName = customerName;
        AccountNumber = accountNumber;
        Balance = balance;
        Currency = currency;
    }
}
