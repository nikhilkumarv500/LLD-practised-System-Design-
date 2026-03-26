package Manager;

import java.util.*;

import DarkStore.DarkStore;
import Models.Product;
import Replinish.IReplinishStrategy;
import Replinish.TresholdReplinish;
import Replinish.WeeklyReplinsh;

public class DarkStoreManager {
    

    static DarkStoreManager selfObj;
    List<DarkStore> darkStoreLists;
    IReplinishStrategy iReplinishStrategy;

    private DarkStoreManager(){
        darkStoreLists = new ArrayList<>();
    }

    public static DarkStoreManager getInstance() {
        if(selfObj==null) selfObj = new DarkStoreManager();
        return selfObj;
    }

    public void createAndAddDarkStore(DarkStore darkStore) {
        darkStoreLists.add(darkStore);
    }

    public List<DarkStore> getNearByStores(int x, int y, int maxDistance) {
        List<DarkStore> arr = new ArrayList<>();

        for(DarkStore cur: darkStoreLists) {
            int storeDis = cur.getX() + cur.getY();
            int cusDis = x+y;

            if((storeDis - cusDis) <= maxDistance) {
                arr.add(cur);
            }
            
        }

        return arr;

    }

    public void replinishStock(String darkStoreName, Map<Integer, Integer> sku_quantity) {

        DarkStore darkStore = null;

        for(DarkStore x:darkStoreLists) {
            if(x.getName().equals(darkStoreName)) {
                darkStore=x;
                break;
            }
        }

        if(darkStore == null) {
            System.out.println("Store not found to replinish | DarkStoreManager");
            return;
        }

        for(Map.Entry<Integer, Integer> x: sku_quantity.entrySet()) {
            darkStore.addProductToInventory(x.getKey(), x.getValue());
        }

        System.out.println("Replinished Stocks In darkStore" + darkStore.getName());

    }

    public DarkStore getDarkStoreByName(String name) {
        for(DarkStore x: darkStoreLists) {
            if(x.getName().equals(name)) return x;
        }
        return null;
    }

    public void ThresholdReplinish(String darkStoreName, Map<Integer, Integer> sku_quantity) {
        DarkStore darkStore = getDarkStoreByName(darkStoreName);

        iReplinishStrategy = new TresholdReplinish();
        iReplinishStrategy.replinishStrategy(darkStore, sku_quantity);
    }

    public void weeklyReplisnish(String darkStoreName, Map<Integer, Integer> sku_quantity) {
        DarkStore darkStore = getDarkStoreByName(darkStoreName);
        iReplinishStrategy = new WeeklyReplinsh();
        iReplinishStrategy.replinishStrategy(darkStore, sku_quantity);
    }

}
