package Lesson1_ProductBeans;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final Cart cart;
//    public static void main(String[] args) {
//        ProductRepository productRepository = new ProductRepository();
//        productRepository.addFifeProduct();
//        System.out.println(productRepository);
//        System.out.println(productRepository.getMapProduct().get("2").toString());
//        System.out.println(productRepository.getProduct("3").toString());
//    }

    public Init(ProductRepository productRepository, Cart cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.addFifeProduct();
//        System.out.println("Run" + productRepository.getMapProduct().values().toArray().toString());
        cart.addToCart(1, productRepository.getProduct(1));
        cart.addToCart(2, productRepository.getProduct(2));
        cart.addToCart(3, productRepository.getProduct(3));
        System.out.println("3 товара в корзине: " + cart);
        cart.clearCart(2);
        System.out.println("удалили товар с id 2: " + cart);
        cart.clearCart(1);
        cart.clearCart(3);
        System.out.println("Корзина пустая: " + cart);
//        System.out.println(productRepository.getProduct("3").toString());
    }
}
