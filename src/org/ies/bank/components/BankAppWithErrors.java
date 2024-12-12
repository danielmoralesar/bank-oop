package org.ies.bank.components;

import org.ies.bank.model.Account;

public class BankAppWithErrors {
    private final BankReader bankReader;

    public BankAppWithErrors(BankReader bankReader) {
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
