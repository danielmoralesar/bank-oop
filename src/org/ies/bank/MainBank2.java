package org.ies.bank;

import org.ies.bank.components.scanner.ScannerAccountReader;
import org.ies.bank.components.scanner.BankApp2;
import org.ies.bank.components.scanner.ScannerBankReader;
import org.ies.bank.components.scanner.ScannerCustomerReader;

import java.util.Scanner;

public class MainBank2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var customerReader = new ScannerCustomerReader(scanner);
        var accountReader = new ScannerAccountReader(scanner, customerReader);
        var bankReader = new ScannerBankReader(scanner, accountReader);
        var bankApp2 = new BankApp2(bankReader);

        bankApp2.run();
    }
}