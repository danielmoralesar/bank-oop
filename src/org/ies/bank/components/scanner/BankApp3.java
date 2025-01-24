package org.ies.bank.components.scanner;

public class BankApp3 {
    private final ScannerBankReader scannerBankReader;

    public BankApp3(ScannerBankReader scannerBankReader) {
        this.scannerBankReader = scannerBankReader;
    }

    public void run() {
        var bank = scannerBankReader.read();

        bank.showAccounts();
        bank.withdraw("ES0003", 50.00);
        bank.showCustomerAccounts("000X");
        bank.deposit("ES004", 300.00);
        bank.showCustomer("ES0001");
    }
}
