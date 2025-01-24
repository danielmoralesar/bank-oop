package org.ies.bank.components.scanner;

import org.ies.bank.model.Account;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class ScannerAccountReader {
    private final Scanner scanner;
    private final ScannerCustomerReader scannerCustomerReader;

    public ScannerAccountReader(Scanner scanner, ScannerCustomerReader scannerCustomerReader) {
        this.scanner = scanner;
        this.scannerCustomerReader = scannerCustomerReader;
    }

    public Account read() {
        System.out.println("Ingrese los datos de su cuenta");
        System.out.println("Ingrese su IBAN: ");
        String iban = scanner.nextLine();
        System.out.println("Ingrese su saldo actual: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        Customer customer = scannerCustomerReader.read();

        return new Account(
                iban,
                balance,
                customer
        );
    }
}
