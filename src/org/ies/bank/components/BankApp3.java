package org.ies.bank.components;

public class BankApp3 {
    private final BankReader bankReader;

    public BankApp3(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        var bank = bankReader.read();

        bank.showAccounts();
        bank.withdraw("ES0003", 50.00);
        bank.showCustomerAccounts("000X");
        bank.deposit("ES004", 300.00);
        bank.showCustomer("ES0001");
    }
}
