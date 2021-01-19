package Lesson1_ProductBeans;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private Product product1 = new Product("1", "Apple",20.0f);
    private Product product2 = new Product("2", "Orange",40.5f);
    private Product product3 = new Product("3", "Tomato",38.2f);
    private Product product4 = new Product("4", "Carrot",10.9f);
    private Product product5 = new Product("5", "Onion",7.3f);
//    private Map<String, Product> mapProduct;

    public ProductRepository() {
        Map<String, Product> mapProduct = new HashMap<String, Product>();
        mapProduct.put(product1.getId(), product1);
        mapProduct.put(product2.getId(), product2);
        mapProduct.put(product3.getId(), product3);
        mapProduct.put(product4.getId(), product4);
        mapProduct.put(product5.getId(), product5);
    }

//    public Map<String, Product> getMapProduct() {
//        return mapProduct;
//    }
}
