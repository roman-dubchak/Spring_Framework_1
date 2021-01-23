package Lesson1_ProductBeans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component("productRepository")
public class ProductRepository implements ProductRepositoryInterface {
    private Product product1 = new Product(1, "Potato",20.0f);
    private Product product2 = new Product(2, "Orange",40.5f);
    private Product product3 = new Product(3, "Tomato",38.2f);
    private Product product4 = new Product(4, "Carrot",10.9f);
    private Product product5 = new Product(5, "Onion",7.3f);
    private Map<Integer, Product> mapProduct = new HashMap<Integer, Product>();

    @Override
    @PostConstruct
    public void addFifeProduct() {
        mapProduct.put(product1.getId(), product1);
        mapProduct.put(product2.getId(), product2);
        mapProduct.put(product3.getId(), product3);
        mapProduct.put(product4.getId(), product4);
        mapProduct.put(product5.getId(), product5);
        System.out.println("The repository contains: " + Arrays.toString(mapProduct.values().toArray()));
    }

//    Вариант добавляения товаров при вызове конструктора
//    public ProductRepository() {
//        mapProduct.put(product1.getId(), product1);
//        mapProduct.put(product2.getId(), product2);
//        mapProduct.put(product3.getId(), product3);
//        mapProduct.put(product4.getId(), product4);
//        mapProduct.put(product5.getId(), product5);
//        System.out.println(Arrays.toString(mapProduct.values().toArray()));
//    }

    public Map<Integer, Product> getMapProduct() {
        return mapProduct;
    }
    public Product getProduct(Integer id) {
        return mapProduct.get(id);
    }
}
