package Models;

public class Product {
    int sku;
    String name;
    int price;

    

    public Product(int sku, String name, int price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }
    public int getSku() {
        return sku;
    }
    public void setSku(int sku) {
        this.sku = sku;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    
}
