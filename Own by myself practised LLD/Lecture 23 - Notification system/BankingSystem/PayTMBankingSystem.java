package BankingSystem;

import java.util.Random;

public class PayTMBankingSystem implements IBankingSystem {

    Random random = new Random();

    @Override
    public boolean processPaymentInBankingSystem(int amount) {
        int odds = random.nextInt(100);
        return odds < 20; //20% successRate
    }
}
