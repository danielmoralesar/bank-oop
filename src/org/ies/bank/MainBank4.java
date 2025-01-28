package org.ies.bank;

import org.ies.bank.components.app.BankApp4;
import org.ies.bank.components.readers.random.RandomAccountReader;
import org.ies.bank.components.readers.random.RandomBankReader;
import org.ies.bank.components.readers.random.RandomCustomerReader;

import java.util.Random;

public class MainBank4 {
    public static void main(String[] args) {
        var random = new Random();
        var customerReader = new RandomCustomerReader(random);
        var accountReader = new RandomAccountReader(random, customerReader);
        var bankReader = new RandomBankReader(random, accountReader);
        var bankApp4 = new BankApp4(bankReader);

        bankApp4.run();
    }
}