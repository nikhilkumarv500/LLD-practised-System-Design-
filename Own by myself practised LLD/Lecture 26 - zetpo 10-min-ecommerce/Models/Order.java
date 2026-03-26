package Models;

import java.util.Map;

public class Order {
    String user;
    Map<Integer, Integer> itemUserWants_sku_quantity;
    int user_x;
    int user_y;

    public Order(String user, int x, int y, Map<Integer, Integer> itemUserWants_sku_quantity) {
        this.user = user;
        this.itemUserWants_sku_quantity = itemUserWants_sku_quantity;
        user_x=x;
        user_y=y;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Map<Integer, Integer> getItemUserWants_sku_quantity() {
        return itemUserWants_sku_quantity;
    }

    public void setItemUserWants_sku_quantity(Map<Integer, Integer> itemUserWants_sku_quantity) {
        this.itemUserWants_sku_quantity = itemUserWants_sku_quantity;
    }

    public int getUser_x() {
        return user_x;
    }

    public void setUser_x(int user_x) {
        this.user_x = user_x;
    }

    public int getUser_y() {
        return user_y;
    }

    public void setUser_y(int user_y) {
        this.user_y = user_y;
    }

    
    

}
