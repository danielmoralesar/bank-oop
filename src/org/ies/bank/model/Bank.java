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

    public void withdraw(String iban, double amount) {
        var account = findAccountViaIban(iban);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.deposit(-amount);
                showAccount(iban);
            } else {
                System.out.println("La cuenta no tiene fondos suficientes");
            }
        } else {
            System.out.println("No se encuentra la cuenta");
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

    public void transfer(Account origin, Account destination, double amount) {
        if (origin != null && destination != null && origin.getBalance() >= amount && origin != destination) {
            withdraw(origin.getIban(), amount);
            deposit(destination.getIban(), amount);
            System.out.println("Transferencia realizada con exito");
        } else {
            System.out.println("No se ha podido hacer la transferencia debido a: ");
            if (origin == null || destination == null) {
                System.out.println("IBAN incorrecto de alguna de las dos cuentas");
            } else if (origin.getBalance() < amount) {
                System.out.println("Saldo insuficiente");
            } else if (origin == destination) {
                System.out.println("Ambas cuentas son la misma.");
            }
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

    public void showCustomer(String iban) {
        var customer = findCustomer(iban);
        if (customer != null) {
            customer.showCustomer();
        } else {
            System.out.println("Este número IBAN es inválido");
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
