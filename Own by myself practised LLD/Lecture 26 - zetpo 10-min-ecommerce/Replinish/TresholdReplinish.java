package Replinish;

import java.util.Map;

import DarkStore.DarkStore;

public class TresholdReplinish implements IReplinishStrategy {

    @Override
    public void replinishStrategy(DarkStore darkStore, Map<Integer, Integer> sku_quantity_ToAdd) {
        Map<Integer, Integer> current_Sku_Quantity_Map = darkStore.getSkuQuantityMap();

        for(Map.Entry<Integer, Integer> cur: sku_quantity_ToAdd.entrySet()) {
            int sku = cur.getKey();
            int quantity = cur.getValue();
            int currentQuantity = current_Sku_Quantity_Map.get(sku);

            if(currentQuantity<quantity) {
                darkStore.addProductToInventory(sku, quantity);

                System.out.print("\n\nAfter replinish");
                System.out.println("DarkStore = " + darkStore.getName() 
                + " | quantity updated for = " + sku);
                
                darkStore.listAllStocksFromInventory();

            }
            
        }   
    }
    
}
