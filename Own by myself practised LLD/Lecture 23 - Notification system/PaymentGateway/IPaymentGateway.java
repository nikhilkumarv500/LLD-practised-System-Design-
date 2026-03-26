package PaymentGateway;

import BankingSystem.IBankingSystem;
import Model.PaymentRequest;

public abstract class IPaymentGateway {
    IBankingSystem bankingSystem;

    IPaymentGateway(IBankingSystem iBankingSystem ) {
        this.bankingSystem = iBankingSystem;
    }

    public boolean processPayment(PaymentRequest paymentRequest) {
        if(!validatePayment(paymentRequest)) {
            System.out.println("Validation failed at: IPaymentGateway");
            return false;
        }
        if(!initiatePayment(paymentRequest)) {
            System.out.println("InitiatePayment failed at: IPaymentGateway");
            return false;
        }
        if(!confirmPayment(paymentRequest)) {
            System.out.println("ConfirmPayment failed at: IPaymentGateway");
            return false;
        }
        return true;
    }

    public abstract boolean validatePayment(PaymentRequest paymentRequest);
    public abstract boolean initiatePayment(PaymentRequest paymentRequest);
    public abstract boolean confirmPayment(PaymentRequest paymentRequest);
    public abstract void printPaymentGatewayType();


}
