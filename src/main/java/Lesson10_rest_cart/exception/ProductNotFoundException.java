package Lesson10_rest_cart.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String massage){
        super(massage);
    }
}
