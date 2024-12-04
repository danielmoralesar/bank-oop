package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class AccountReader {
    private final Scanner scanner;
    private final CustomerReader customerReader;

    public AccountReader(Scanner scanner, CustomerReader customerReader) {
        this.scanner = scanner;
        this.customerReader = customerReader;
    }

    public Account read(){
        System.out.println("Ingrese los datos de su cuenta");
        String iban;
        do {
            System.out.println("Ingrese su IBAN: ");
            iban = scanner.nextLine();
        } while (iban == null);
        System.out.println("su IBAN es: " + iban);
        System.out.println("Ingrese su saldo actual: ");
        double balance = scanner.nextDouble();

        Customer customer = customerReader.read();

        return new Account(
                iban,
                balance,
                customer
        );
    }
}
