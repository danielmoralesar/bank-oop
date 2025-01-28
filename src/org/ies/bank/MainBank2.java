package org.ies.bank;

import org.ies.bank.components.app.BankApp2;
import org.ies.bank.components.readers.random.RandomAccountReader;
import org.ies.bank.components.readers.random.RandomBankReader;
import org.ies.bank.components.readers.random.RandomCustomerReader;

import java.util.Random;

public class MainBank2 {
    public static void main(String[] args) {
        var random = new Random();
        var customerReader = new RandomCustomerReader(random);
        var accountReader = new RandomAccountReader(random, customerReader);
        var bankReader = new RandomBankReader(random, accountReader);
        var bankApp2 = new BankApp2(bankReader);

        bankApp2.run();
    }
}