package Manager;

import java.util.Map;

import Inventory.IInventoryStore;

public class InventoryManager {
    IInventoryStore iInventoryStore;

    public InventoryManager( IInventoryStore iInventoryStore) {
        this.iInventoryStore = iInventoryStore;
    }

    public void addProduct(int sku, int quantity) {
        iInventoryStore.addProduct(sku, quantity);
    }

    public void removeProduct(int sku, int quantity) {
        iInventoryStore.removeProduct(sku, quantity);
    }

    public boolean checkStock(int sku) {
        return iInventoryStore.checkStock(sku);
    }

    public void getAvailableProducts() {
        iInventoryStore.listAllStocks();
    }

    public Map<Integer, Integer> getSkuQuantityMap() {
        return iInventoryStore.getSkuQuantityMap();
    }


}
