package Factory;

import Models.Product;

public class ProductFactory {

    static ProductFactory selfObj;

    private ProductFactory(){}

    public static ProductFactory getInstance() {
        if(selfObj==null) selfObj=new ProductFactory();
        return selfObj;
    }

    public Product createProduct(int sku) {
        String name = "";

        if(sku==1) name="Mango";
        else if(sku==2) name = "Apple";
        else if(sku==11) name = "Wheat";
        else if(sku==22) name = "Rice";
        else name = "Chocolate";

        return new Product(sku,name,100);
    }
    
}
