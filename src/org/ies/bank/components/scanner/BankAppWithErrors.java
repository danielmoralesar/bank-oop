package org.ies.bank.components.scanner;

import org.ies.bank.model.Account;

public class BankAppWithErrors {
    private final ScannerBankReader scannerBankReader;

    public BankAppWithErrors(ScannerBankReader scannerBankReader) {
        this.scannerBankReader = scannerBankReader;
    }

    public void run() {
        var bank = scannerBankReader.read();

        Account account = bank.findAccountViaIban("ES0001");
        if (account != null) {
            account.showInfo();
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }
}
