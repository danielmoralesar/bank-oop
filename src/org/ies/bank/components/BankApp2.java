package org.ies.bank.components;

import org.ies.bank.model.Account;

public class BankApp2 {
    private final BankReader bankReader;

    public BankApp2(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run(){
        var bank = bankReader.read();

        String iban1 = "ES0001";
        Account firstAccount = bank.findAccountViaIban(iban1);
        if (firstAccount != null){
            bank.deposit(iban1, 500);
        } else {
            System.out.println("La cuenta no existe");
        }

        String iban2 = "ES0002";
        Account secondAccount = bank.findAccountViaIban(iban2);
        if (secondAccount != null){
            bank.withdraw(iban2, 30);
        } else {
            System.out.println("La cuenta no existe");
        }

        bank.showAccount(iban1);
        bank.showAccount(iban2);

        bank.transfer(firstAccount, secondAccount, 500);
    }
}
