package Manager;

import java.util.List;
import java.util.Map;

import DarkStore.DarkStore;
import Models.Order;

public class OrderManager {
    DarkStoreManager darkStoreManager;
    Order order;

    public OrderManager(Order order, DarkStoreManager darkStoreManager) {
        this.order=order;
        this.darkStoreManager=darkStoreManager;
    }
    
    public void placeOrder() {
        int total = 0;

        Map<Integer, Integer> order_sku_quatity = order.getItemUserWants_sku_quantity();

        List<DarkStore> darkStoreList = darkStoreManager.
                getNearByStores(order.getUser_x(), order.getUser_y(), 11);

        int index=1;

        for(DarkStore x: darkStoreList) {
            Map<Integer, Integer> darkStore_sku_quantity = x.getSkuQuantityMap();

            System.out.println("delivary to Customer from = Delivarypartner-" + index++);

            for(Map.Entry<Integer, Integer> cur: order_sku_quatity.entrySet()) {
                int order_sku = cur.getKey();
                int order_quantity = cur.getValue();

                if(order_quantity==0) continue;

                if(darkStore_sku_quantity.containsKey(order_sku)) {
                    int darkStoreItemQuantity = darkStore_sku_quantity.get(order_sku);
                    if(order_quantity<=darkStoreItemQuantity) {
                        System.out.println("Item = " + order_sku + " | quantity = " + order_quantity);
                        order_sku_quatity.put(order_sku,0);
                    } else {
                        int rems = order_quantity - darkStoreItemQuantity;
                        System.out.println("Item = " + order_sku + " | quantity = " + darkStoreItemQuantity);
                        order_sku_quatity.put(order_sku,rems);
                    }
                }

            }

        }

    }



}
