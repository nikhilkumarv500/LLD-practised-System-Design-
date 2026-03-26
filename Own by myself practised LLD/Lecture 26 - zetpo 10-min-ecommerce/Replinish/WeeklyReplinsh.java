package Replinish;

import java.util.Map;

import DarkStore.DarkStore;

public class WeeklyReplinsh implements IReplinishStrategy {
    @Override
    public void replinishStrategy(DarkStore darkStore, Map<Integer, Integer> sku_quantity) {
        System.out.println("Weekly updates for darkStore = " + darkStore.getName() );
    }
}
