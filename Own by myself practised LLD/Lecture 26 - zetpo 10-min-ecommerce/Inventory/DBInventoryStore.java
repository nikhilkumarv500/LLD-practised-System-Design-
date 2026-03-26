package Inventory;

import java.util.*;

import Factory.ProductFactory;
import Models.Product;

public class DBInventoryStore implements IInventoryStore {
    Map<Integer, Product> sku_Product = new HashMap<>();    
    Map<Integer, Integer> sku_quantity = new HashMap<>();

    @Override
    public void addProduct(int sku, int quantity) {
        ProductFactory productFactory = ProductFactory.getInstance();
        if(sku_Product.containsKey(sku)) {
            System.out.println("Item exists already: DBInventoryStore");
            sku_quantity.put(sku,quantity);
            return;
        }
        sku_Product.put(sku, productFactory.createProduct(sku));
        sku_quantity.put(sku,quantity);

    }

    @Override
    public boolean checkStock(int sku) {
        return sku_Product.containsKey(sku);
    }

    @Override
    public void listAllStocks() {

        System.out.println("---------------------");
        System.out.println("Listing all products");

        for(Map.Entry<Integer, Product> x: sku_Product.entrySet()) {
            System.out.println(x.getKey() + "   " + x.getValue().getName() + "   " +sku_quantity.get(x.getKey()));
        }
        System.out.println("---------------------");


        
    }

    @Override
    public Map<Integer, Integer> getSkuQuantityMap() {
        return sku_quantity;
    }

    @Override
    public void removeProduct(int sku, int quantity) {

        if(sku_Product.containsKey(sku) == false) {
            System.out.println("Item does not existx : DBInventoryStore");
            return;
        }

        int presentQ = sku_quantity.get(sku);
        if(presentQ<quantity) {
            sku_Product.remove(sku);
            sku_quantity.remove(sku);
            System.out.println("Removed item");
        } else {
            sku_quantity.put(sku,presentQ-quantity);
            System.out.println("Updated quantity");
        }
        
    }

    


}
