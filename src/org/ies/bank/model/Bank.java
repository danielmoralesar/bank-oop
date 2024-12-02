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

    public void showAccounts (){
        for (Account account : accounts){
            account.showInfo();
        }
    }

    public void findAccount (String iban){
        for (var account: accounts){
            if (account.getIban().equals(iban)){
                account.showInfo();
            }
        }
    }

    public Account returnAccount (String iban){
        for (var account: accounts){
            if (account.getIban().equals(iban)){
                return account;
            }
        }
        return null;
    }

    public void findCustomersAccounts (String nif){
        for (var account: accounts){
            if (account.getCustomer().getNif().equals(nif)){
                account.showInfo();
            }
        }
    }

    public void depositInAccount (String iban, double money){
        var account = returnAccount(iban);
        if (account != null){
            account.setBalance(account.getBalance() + money);
        }
        else {
            System.out.println("No se encuentra la cuenta");
        }
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
