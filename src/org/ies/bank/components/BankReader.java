package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankReader {
    private final Scanner scanner;
    private final AccountReader accountReader;

    public BankReader(Scanner scanner, AccountReader accountReader) {
        this.scanner = scanner;
        this.accountReader = accountReader;
    }

    public Bank read(){
        System.out.println("Ingrese el nombre del banco: ");
        String banksName = scanner.nextLine();

        int countAccounts = 0;
        do{
            System.out.println("¿Cuantas cuentas tiene el banco?");
            countAccounts = scanner.nextInt();
            if (countAccounts < 1){
                System.out.println("El banco no puede tener menos de una cuenta");
            }
        } while (countAccounts < 1);

        Account[] accounts = new Account[countAccounts];
        for (int i = 0; i < countAccounts; i++) {
            //pendiente hacer bucle
        }
    }
}
