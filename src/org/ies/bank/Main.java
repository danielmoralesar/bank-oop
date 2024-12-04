package org.ies.bank;

import org.ies.bank.components.AccountReader;
import org.ies.bank.components.BankApp;
import org.ies.bank.components.BankReader;
import org.ies.bank.components.CustomerReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var CustomerReader = new CustomerReader(scanner);
        var AccountReader = new AccountReader(scanner, CustomerReader);
        var BankReader = new BankReader(scanner, AccountReader);
        var BankApp = new BankApp(scanner, BankReader);

        BankApp.run();
    }
}