package org.ies.bank.components.readers.random;

import org.ies.bank.components.readers.CustomerReader;
import org.ies.bank.model.Customer;

import java.util.Random;

public class RandomCustomerReader implements CustomerReader {
    private final static String[] NAMES = {
            "Pedro", "Rafa", "Miguel", "Olivia", "Terra", "Julian"
    };

    private final static String[] SURNAMES = {
            "Sandía", "Manzana", "Kiwi", "Melón", "Pedro", "Perez"
    };

    private final Random random;

    public RandomCustomerReader(Random random) {
        this.random = random;
    }

    @Override
    public Customer read() {
        return new Customer(
                random.nextLong(100000000) + "X",
                NAMES[random.nextInt(NAMES.length)],
                SURNAMES[random.nextInt(SURNAMES.length)]
        );
    }
}
