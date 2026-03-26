package Service;

import Enums.GatewayType;
import Factory.PaymentGatewayFactory;
import Model.PaymentRequest;
import PaymentGateway.PaymentGatewayProxy;

public class PaymentService {
    PaymentGatewayProxy paymentGatewayProxy;
    static PaymentService selfObj;

    public static PaymentService getInstance() {
        if(selfObj == null) selfObj = new PaymentService();
        return selfObj;
    }

    public void createGateway(GatewayType type) {
        paymentGatewayProxy = PaymentGatewayFactory.getInstance().generatePaymentGateway(type);
    }

    public void processPayment(PaymentRequest paymentRequest, int retries) {
        paymentGatewayProxy.processPaymentThroughProxy(paymentRequest, retries);
    }
}
