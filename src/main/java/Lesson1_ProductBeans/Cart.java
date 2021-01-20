package Lesson1_ProductBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cart implements CartInterface{
//    private Product product5 = new Product(6, "Milk",10.0f);

    private ProductRepository productRepository;

    private Map<Integer, Product> mapCart = new HashMap<Integer, Product>();
    Integer idProductInCart = 1;

//    @Override
//    public ProductRepository getProductRepo() {
//        return null;
//    }

    @Override
    public void addToCart(Integer id, Product product) {
        mapCart.put(id, product);
        System.out.println("You add to cart product: " + (mapCart.get(id).toString()));
//        idProductInCart++;
    }

    @Override
    public void clearCart(Integer id) {
        System.out.println("You remove cart product: " + (mapCart.get(id).toString()));

        mapCart.remove(id);
        //        idProductInCart--;
    }

    @Override
    public String toString() {
        if (mapCart.size() == 0) {
            return "Cart is empty";
        } else return "The cart contains: "
                + mapCart.values().toString();
    }
}
