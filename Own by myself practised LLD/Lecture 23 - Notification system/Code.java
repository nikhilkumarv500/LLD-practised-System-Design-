import java.util.*;

import Controller.PaymentController;
import Enums.GatewayType;
import Model.PaymentRequest;

class client {


    void run() {
    
    
    PaymentController paymentController = PaymentController.getInstance();

    
    //payment attempt 1
    paymentController.createGateway(GatewayType.PAYTM);
    PaymentRequest paymentRequest1 = new PaymentRequest("personA", "Person-B", 500, "INR");
    paymentController.processPayment(paymentRequest1, 3);

    System.out.println("-----------------");
    
    //paymnet attempt 2
    paymentController.createGateway(GatewayType.RAZORPAY);
    PaymentRequest paymentRequest2 = new PaymentRequest("persno-2","person-4", 1000, "dszdbd");
    paymentController.processPayment(paymentRequest2, 2);


    }
}

public class Code {
    public static void main(String[] args) {
        // TimeoutHelper.startTimeout(5000);

        Scanner sc = new Scanner(System.in);

        client obj = new client();
        obj.run();

        // TimeoutHelper.cancelTimeout();

    }
}
