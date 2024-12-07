package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String banksName;
    private Account[] accounts;

    public Bank(String banksName, Account[] accounts) {
        this.banksName = banksName;
        this.accounts = accounts;
    }

    public void showAccounts() {
        for (Account account : accounts) {
            account.showInfo();
        }
    }

    public void showAccount(String iban) {
        var account = findAccountViaIban(iban);
        if (account == null) {
            System.out.println("No se encuentra la cuenta");
        } else {
            account.showInfo();
        }

    }

    public Account findAccountViaIban(String iban) {
        for (var account : accounts) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }

    public Account verifyNif(String nif) {
        for (var account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                return account;
            }
        }
        return null;
    }

    public void showCustomerAccounts(String nif) {
        for (var account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                account.showInfo();
            }
        }
    }

    public void deposit(String iban, double amount) {
        var account = findAccountViaIban(iban);
        if (account != null) {
            account.deposit(amount);
            showAccount(iban);
        } else {
            System.out.println("No se encuentra la cuenta");
        }
    }

    public int countAccounts(String nif) {
        int counter = 0;
        for (var account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                counter++;
            }
        }
        return counter;
    }

    public Customer findCustomer(String iban) {
        for (var account : accounts) {
            if (account.getIban().equals(iban)) {
                return account.getCustomer();
            }
        }
        return null;
    }

    public String getBanksName() {
        return banksName;
    }

    public void setBanksName(String banksName) {
        this.banksName = banksName;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(banksName, bank.banksName) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(banksName, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "banksName='" + banksName + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
