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
