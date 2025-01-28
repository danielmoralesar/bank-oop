package org.ies.bank;

import org.ies.bank.components.readers.random.RandomAccountReader;
import org.ies.bank.components.readers.random.RandomBankReader;
import org.ies.bank.components.readers.random.RandomCustomerReader;
import org.ies.bank.components.app.BankApp;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var random = new Random();
        var customerReader = new RandomCustomerReader(random);
        var accountReader = new RandomAccountReader(random, customerReader);
        var bankReader = new RandomBankReader(random, accountReader);
        var bankApp = new BankApp(scanner, bankReader);

        bankApp.run();
    }
}