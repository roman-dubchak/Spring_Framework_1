package Lesson3_MVC_WEB_Start.repositories;

import Lesson3_MVC_WEB_Start.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component()
public class ProductRepository {
    private List<Product> listProduct;

    @PostConstruct
    public void init() {
        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Potato", 20));
        listProduct.add(new Product(2, "Orange", 40));
        listProduct.add(new Product(3, "Tomato", 38));
        listProduct.add(new Product(4, "Carrot", 10));
        listProduct.add(new Product(5, "Onion", 7));
        listProduct.add(new Product(6, "Apple", 25));
        System.out.println("The repository contains: " + (listProduct.toArray().toString()));
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public Product getProduct(Integer id) {
        Product product = new Product();
        for (int i = 0; i < listProduct.size(); i++) {
            if (id.equals(listProduct.get(i).getId())) ;
            product = listProduct.get(i);
        }
        return product;
    }

    public void saveProduct(Product product) {
        listProduct.add(product);
    }
}
