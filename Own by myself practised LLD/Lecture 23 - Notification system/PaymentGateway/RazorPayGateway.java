package PaymentGateway;

import BankingSystem.RazonPayBankingSystem;
import Model.PaymentRequest;

public class RazorPayGateway extends IPaymentGateway {

    public RazorPayGateway() {
        super(new RazonPayBankingSystem());
    }

    @Override
    public boolean validatePayment(PaymentRequest paymentRequest) {
        if(paymentRequest.getAmount()<=0) return false;
        return true;
    }
    

    @Override
    public boolean initiatePayment(PaymentRequest paymentRequest) {
        boolean PaymentFromGateway = bankingSystem.processPaymentInBankingSystem(paymentRequest.getAmount());
        return PaymentFromGateway;
    }
    

    @Override
    public boolean confirmPayment(PaymentRequest paymentRequest) {
        // just as an example
        return true;
    }

    @Override
    public void printPaymentGatewayType() {
        System.out.println("RazorPayGateway");
        
    }
    
}
