package Replinish;

import java.util.Map;

import DarkStore.DarkStore;

public interface IReplinishStrategy {
    void replinishStrategy(DarkStore darkStore, Map<Integer, Integer> sku_quantity);
}
