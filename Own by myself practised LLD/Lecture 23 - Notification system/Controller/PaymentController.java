package Controller;

import Enums.GatewayType;
import Model.PaymentRequest;
import Service.PaymentService;

public class PaymentController {
    PaymentService paymentService;
    static PaymentController selfObj;

    public static PaymentController getInstance() {
        if(selfObj == null) selfObj = new PaymentController();
        return selfObj;
    }

    public PaymentController() {
        paymentService = PaymentService.getInstance();
    }

    public void createGateway(GatewayType type) {
        paymentService.createGateway(type);
    }

    public void processPayment(PaymentRequest paymentRequest, int retries) {
        paymentService.processPayment(paymentRequest, retries);
    }

}
