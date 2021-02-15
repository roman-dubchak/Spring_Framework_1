package Lesson8_thymeleaf.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String massage){
        super(massage);
    }
}
