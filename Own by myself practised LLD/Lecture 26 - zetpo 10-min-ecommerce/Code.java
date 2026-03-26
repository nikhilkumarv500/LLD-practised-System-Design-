import java.util.*;

import DarkStore.DarkStore;
import Manager.DarkStoreManager;
import Manager.OrderManager;
import Models.Order;

class client {


    void run() {

        DarkStore darkStore1 = new DarkStore("Dark-Store-1", 5, 5);
        darkStore1.addProductToInventory(1, 2); // mango
        darkStore1.addProductToInventory(2, 2); // Apple
        darkStore1.addProductToInventory(11, 2); // Wheat
        darkStore1.addProductToInventory(22, 2); // rice

        DarkStore darkStore2 = new DarkStore("Dark-Store-2", 5, 4);
        darkStore2.addProductToInventory(1, 2); // mango
        darkStore2.addProductToInventory(11, 2); // rice

        DarkStore darkStore3 = new DarkStore("Dark-Store-3", 5, 6);
        darkStore3.addProductToInventory(1, 100); // mango
        darkStore3.addProductToInventory(11, 100); // rice

        DarkStore darkStore4 = new DarkStore("Dark-Store-4", 50, 60);

        //Create DarkStore lists
        DarkStoreManager darkStoreManager = DarkStoreManager.getInstance();
        darkStoreManager.createAndAddDarkStore(darkStore1);
        darkStoreManager.createAndAddDarkStore(darkStore2);
        darkStoreManager.createAndAddDarkStore(darkStore3);
        darkStoreManager.createAndAddDarkStore(darkStore4);

        // listAllStocksFromInventory from all darkStore
        List<DarkStore> darkStoreList = darkStoreManager.getNearByStores(1,1, 10);
        for(DarkStore x: darkStoreList) {
            x.listAllStocksFromInventory();
        }
        System.out.println("+++++++++++++++++=");

        //Treshold replinish stock
        Map<Integer, Integer> replinishStock_sku_quantity = new HashMap<>();
        replinishStock_sku_quantity.put(1,500);
        darkStoreManager.ThresholdReplinish("Dark-Store-3", replinishStock_sku_quantity);

        System.out.println("after replinshing darkStore-3");
        darkStoreManager.getDarkStoreByName("Dark-Store-3").listAllStocksFromInventory();

        System.out.println("+++++++++++++++++=");

        //Order from user 1
        Map<Integer, Integer> User1Order = new HashMap<>();
        User1Order.put(1, 3);
        User1Order.put(11, 5);
        Order order1 = new Order("User1", 1, 1, User1Order);

        OrderManager orderManager = new OrderManager(order1, darkStoreManager);
        orderManager.placeOrder();








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
