package Factory;

import Enums.GatewayType;
import PaymentGateway.PayTMGateway;
import PaymentGateway.PaymentGatewayProxy;
import PaymentGateway.RazorPayGateway;

public class PaymentGatewayFactory {
    static PaymentGatewayFactory selfObj;

    private PaymentGatewayFactory(){}

    public static PaymentGatewayFactory getInstance() {
        if(selfObj == null) selfObj = new PaymentGatewayFactory();
        return selfObj;
    }

    public PaymentGatewayProxy generatePaymentGateway(GatewayType type) {
        if(type == GatewayType.PAYTM) {
            return new PaymentGatewayProxy(new PayTMGateway());
        }
        else return new PaymentGatewayProxy(new RazorPayGateway());
    }

}
