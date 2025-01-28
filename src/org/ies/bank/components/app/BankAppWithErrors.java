package org.ies.bank.components.app;

import org.ies.bank.components.readers.scanner.ScannerBankReader;
import org.ies.bank.model.Account;

public class BankAppWithErrors {
    private final ScannerBankReader bankReader;

    public BankAppWithErrors(ScannerBankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        var bank = bankReader.read();

        Account account = bank.findAccountViaIban("ES0001");
        if (account != null) {
            account.showInfo();
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }
}
