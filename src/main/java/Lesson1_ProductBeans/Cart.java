package Lesson1_ProductBeans;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cart implements CartInterface {
    private Map<Integer, Product> mapCart = new HashMap<Integer, Product>();

    @Override
    public void addToCart(Integer id, Product product) {
        mapCart.put(id, product);
        System.out.println("You add to cart product: " + (mapCart.get(id).toString()));
    }

    @Override
    public void clearCart(Integer id) {
        System.out.println("You remove cart product: " + (mapCart.get(id).toString()));
        mapCart.remove(id);
    }

    @Override
    public String toString() {
        if (mapCart.size() == 0) {
            return "Cart is empty";
        } else return "The cart contains: "
                + mapCart.values().toString();
    }
}
