package org.ies.bank.components.scanner;

import org.ies.bank.model.Account;

public class BankApp2 {
    private final ScannerBankReader scannerBankReader;

    public BankApp2(ScannerBankReader scannerBankReader) {
        this.scannerBankReader = scannerBankReader;
    }

    public void run() {
        var bank = scannerBankReader.read();

        Account firstAccount = bank.findAccountViaIban("ES0001");
        if (firstAccount != null) {
            firstAccount.deposit(500);
        } else {
            System.out.println("La cuenta no existe");
        }

        Account secondAccount = bank.findAccountViaIban("ES0002");
        if (secondAccount != null) {
            secondAccount.deposit(-30);
        } else {
            System.out.println("La cuenta no existe");
        }

        if (firstAccount != null) {
            bank.showAccount(firstAccount.getIban());
        }
        if (secondAccount != null) {
            bank.showAccount(secondAccount.getIban());
        }

        bank.transfer("ES0001", "ES0002", 500);
    }
}
