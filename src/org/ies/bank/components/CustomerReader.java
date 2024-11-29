package org.ies.bank.components;

import org.ies.bank.model.Customer;

import java.util.Scanner;

public class CustomerReader {
    private final Scanner scanner;

    public CustomerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Customer read(){
        System.out.println("Ingrese sus datos personales: ");
        System.out.println("Ingrese su NIF: ");
        String nif = scanner.nextLine();

        System.out.println("Ingrese su nombre: ");
        String name = scanner.nextLine();
        System.out.println("Ingrese su apellido: ");
        String surName = scanner.nextLine();

        return new Customer(
                nif,
                name,
                surName
        );
    }
}
