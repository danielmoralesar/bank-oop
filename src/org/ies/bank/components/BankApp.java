package org.ies.bank.components;

import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;
    private final BankReader bankReader;
    private final AccountReader accountReader;
    private final CustomerReader customerReader;

    public BankApp(Scanner scanner, BankReader bankReader, AccountReader accountReader, CustomerReader customerReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
        this.accountReader = accountReader;
        this.customerReader = customerReader;
    }

    public void run() {

    }
}
