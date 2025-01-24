package org.ies.bank.components.scanner;

public class BankApp4 {
    private final ScannerBankReader scannerBankReader;

    public BankApp4(ScannerBankReader scannerBankReader) {
        this.scannerBankReader = scannerBankReader;
    }

    public void run() {
        var bank = scannerBankReader.read();

        var account = bank.findAccountViaIban("ES0001");
        if (account == null) {
            System.out.println("Error. La cuenta no existe");
        } else {
            account.showInfo();
            bank.transfer("ES0001", "ES0002", account.getBalance());
            bank.showAccounts();
        }
    }
}
