package Lesson1_ProductBeans;

public interface CartInterface {
//    ProductRepository getProductRepo();
    void addToCart(Integer id, Product product);
    void clearCart(Integer id);
}
