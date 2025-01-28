package org.ies.bank;

import org.ies.bank.components.readers.scanner.ScannerAccountReader;
import org.ies.bank.components.app.BankApp4;
import org.ies.bank.components.readers.scanner.ScannerBankReader;
import org.ies.bank.components.readers.scanner.ScannerCustomerReader;

import java.util.Scanner;

public class MainBank4 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var customerReader = new ScannerCustomerReader(scanner);
        var accountReader = new ScannerAccountReader(scanner, customerReader);
        var bankReader = new ScannerBankReader(scanner, accountReader);
        var bankApp4 = new BankApp4(bankReader);

        bankApp4.run();
    }
}