package org.ies.bank.components;

public class BankApp4 {
    private final BankReader bankReader;

    public BankApp4(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        var bank = bankReader.read();

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
