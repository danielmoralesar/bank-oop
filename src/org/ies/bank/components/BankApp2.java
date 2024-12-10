package org.ies.bank.components;

import org.ies.bank.model.Account;

public class BankApp2 {
    private final BankReader bankReader;

    public BankApp2(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        var bank = bankReader.read();

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
