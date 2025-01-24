package org.ies.bank.components.scanner;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class ScannerBankReader {
    private final Scanner scanner;
    private final ScannerAccountReader scannerAccountReader;

    public ScannerBankReader(Scanner scanner, ScannerAccountReader scannerAccountReader) {
        this.scanner = scanner;
        this.scannerAccountReader = scannerAccountReader;
    }

    public Bank read(){
        System.out.println("Ingrese el nombre del banco: ");
        String banksName = scanner.nextLine();

        int countAccounts;
        do{
            System.out.println("¿Cuantas cuentas tiene el banco?");
            countAccounts = scanner.nextInt();
            scanner.nextLine();
            if (countAccounts < 1){
                System.out.println("El banco no puede tener menos de una cuenta");
            }
        } while (countAccounts < 1);

        Account[] accounts = new Account[countAccounts];
        for (int i = 0; i < countAccounts; i++) {
            accounts[i] = scannerAccountReader.read();
        }

        return new Bank(
          banksName,
          accounts
        );
    }
}
