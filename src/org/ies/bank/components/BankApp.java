package org.ies.bank.components;

import org.ies.bank.model.Account;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        System.out.println("Ingrese los datos del banco: ");
        var bank = bankReader.read();

        int option;

        do {
            option = chooseOption();

            if (option == 1) {
                bank.showAccounts();
            } else if (option == 2) {
                System.out.println("Ingrese su número IBAN");
                String iban = scanner.nextLine();
                bank.showAccount(iban);
            } else if (option == 3) {
                System.out.println("Ingrese su NIF");
                String nif = scanner.nextLine();
                if (bank.verifyNif(nif) == null) {
                    System.out.println("No existen cuentas con este NIF");
                } else {
                    bank.showCustomerAccounts(nif);
                }
            } else if (option == 4) {
                System.out.println("Ingrese su número IBAN");
                String iban = scanner.nextLine();
                System.out.println("¿Cúanto va a ingresar?");
                double amount = askAmount();
                bank.deposit(iban, amount);
            } else if (option == 5) {
                System.out.println("Ingrese su número IBAN");
                String iban = scanner.nextLine();
                System.out.println("¿Cúanto va a retirar?");
                double amount = askAmount();
                bank.withdraw(iban, amount);
            } else if (option == 6) {
                System.out.println("Ingrese su NIF");
                String nif = scanner.nextLine();
                int accounts = bank.countAccounts(nif);
                if (accounts < 1) {
                    System.out.println("No existen cuentas con este NIF");
                } else {
                    System.out.println("Este cliente posee " + accounts + " cuentas");
                }
            } else if (option == 7) {
                System.out.println("Ingrese su número IBAN");
                String iban = scanner.nextLine();
                bank.showCustomer(iban);
            } else if (option == 8) {
                System.out.println("Ingrese el IBAN de la cuenta origen");
                String ibanFrom = scanner.nextLine();
                Account origin = bank.findAccountViaIban(ibanFrom);
                System.out.println("Ingrese el IBAN de la cuenta destino");
                String toIban = scanner.nextLine();
                Account destination = bank.findAccountViaIban(toIban);
                System.out.println("¿Cúanto va a transferir?");
                double amount = askAmount();
                bank.transfer(origin, destination, amount);
            } else {
                System.out.println("¡Hasta luego!");
            }
        } while (option != 9);
    }

    private double askAmount() {
        double amount;
        do {
            amount = scanner.nextDouble();
            scanner.nextLine();
            if (amount < 0) {
                System.out.println("Monto no válido, intentelo de nuevo");
            }
        } while (amount < 0);
        return amount;
    }

    private int chooseOption() {
        int option;
        do {
            System.out.println("Elija una operación: ");
            System.out.println("1. Mostrar las cuentas del banco");
            System.out.println("2. Mostrar datos de una cuenta");
            System.out.println("3. Mostrar los datos de las cuentas de un cliente");
            System.out.println("4. Ingresar dinero en una cuenta");
            System.out.println("5. Sacar dinero de una cuenta");
            System.out.println("6. Contar cuentas de un cliente");
            System.out.println("7. Mostrar titular de cuenta");
            System.out.println("8. Hacer una transferencia");
            System.out.println("9. Salir");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option < 1 || option > 9) {
                System.out.println("Opción no válida, inténtelo de nuevo");
            }
        } while (option < 1 || option > 9);
        return option;
    }
}
