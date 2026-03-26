package Inventory;

import java.util.Map;

public interface IInventoryStore {
    void addProduct(int sku, int quantity);
    void removeProduct(int sku, int quantity);
    boolean checkStock(int sku);
    void listAllStocks();
    Map<Integer,Integer> getSkuQuantityMap();
}
