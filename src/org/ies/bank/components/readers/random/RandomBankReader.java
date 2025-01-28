package org.ies.bank.components.readers.random;

import org.ies.bank.components.readers.AccountReader;
import org.ies.bank.components.readers.BankReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Random;

public class RandomBankReader implements BankReader {
    private final Random random;
    private final AccountReader accountReader;

    private final static String[] BANKS = {
            "ClosedBank", "Santadilla", "Gringotts", "Bravo's Bank"
    };

    public RandomBankReader(Random random, AccountReader accountReader) {
        this.random = random;
        this.accountReader = accountReader;
    }

    @Override
    public Bank read() {
        Account[] accounts = new Account[random.nextInt(20)];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = accountReader.read();
        }

        return new Bank(
                BANKS[random.nextInt(BANKS.length)],
                accounts
        );
    }
}
