package Lesson1_ProductBeans;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final Cart cart;
    private final ScannerAp scannerAp;

    public Init(ProductRepository productRepository, Cart cart, ScannerAp scannerAp) {
        this.productRepository = productRepository;
        this.cart = cart;
        this.scannerAp = scannerAp;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.addFifeProduct();
        scannerAp.scannerIdAdd();
        cart.addToCart(scannerAp.getId(), productRepository.getProduct(scannerAp.getId()));

//        Проверка работы корзины
//        cart.addToCart(1, productRepository.getProduct(1));
//        cart.addToCart(2, productRepository.getProduct(2));
//        cart.addToCart(3, productRepository.getProduct(3));
//        System.out.println("3 товара в корзине: " + cart);
//        cart.clearCart(2);
//        System.out.println("удалили товар с id 2: " + cart);
//        cart.clearCart(1);
//        cart.clearCart(3);
//        System.out.println("Корзина пустая: " + cart);
    }
}
