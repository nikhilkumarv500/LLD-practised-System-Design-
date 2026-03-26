package DarkStore;

import java.util.Map;

import Inventory.DBInventoryStore;
import Manager.InventoryManager;

public class DarkStore {
    String name;
    int x,y;
    InventoryManager inventoryManager;



    public DarkStore(String name, int x, int y) {
        this.name=name;
        this.x=x;
        this.y=y;
        inventoryManager = new InventoryManager(new DBInventoryStore());
    }

    public void addProductToInventory(int sku, int quantity) {
        inventoryManager.addProduct(sku, quantity);
    }

    public void removeProductFromInventory(int sku, int quantity) {
        inventoryManager.removeProduct(sku, quantity);
    }

    public void checkStockInInventory(int sku) {
        if(inventoryManager.checkStock(sku)) {
            System.out.println("Stock present = " + sku);
        } else {
            System.out.println("Stock present = " + sku);
        }
    }

    public void listAllStocksFromInventory() {
        System.out.println("From dark store= " + name);
        inventoryManager.getAvailableProducts();
    }

    public Map<Integer, Integer> getSkuQuantityMap() {
        return inventoryManager.getSkuQuantityMap();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public void setInventoryManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    

}
