package BankingSystem;

import java.util.Random;

public class RazonPayBankingSystem implements IBankingSystem {
    Random random = new Random();

    @Override
    public boolean processPaymentInBankingSystem(int amount) {
        int odds = random.nextInt(100);
        return odds < 50; //50% success rate
        
    }

}
