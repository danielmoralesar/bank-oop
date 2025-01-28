package org.ies.bank.components.readers.random;

import org.ies.bank.components.readers.AccountReader;
import org.ies.bank.components.readers.CustomerReader;
import org.ies.bank.model.Account;

import java.util.Random;

public class RandomAccountReader implements AccountReader {
    private final Random random;
    private final CustomerReader customerReader;

    public RandomAccountReader(Random random, CustomerReader customerReader) {
        this.random = random;
        this.customerReader = customerReader;
    }

    @Override
    public Account read() {
        return new Account(
                "ES" + random.nextLong(1000000000L),
                random.nextDouble(100000),
                customerReader.read()
        );
    }
}
