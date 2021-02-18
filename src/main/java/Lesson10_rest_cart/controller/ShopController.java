package Lesson10_rest_cart.controller;

import Lesson10_rest_cart.dto.ProductCartInput;
import Lesson10_rest_cart.dto.ProductInput;
import Lesson10_rest_cart.dto.mapper.ProductCartInputMapper;
import Lesson10_rest_cart.dto.mapper.ProductInputMapper;
import Lesson10_rest_cart.entities.CartProduct;
import Lesson10_rest_cart.entities.Product;
import Lesson10_rest_cart.exception.ProductNotFoundException;
import Lesson10_rest_cart.repo.CartRepository;
import Lesson10_rest_cart.repo.ProductRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController("app/v1/product")
public class ShopController {
    //TODO Реализуйте корзину на REST API,
    // пока что в виде синглтон бина.
    private final ProductRepository productRepository;

//    public ShopController(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
    private final CartRepository cartRepository;

    public ShopController(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable("id") Long id){
        return productRepository.findById(id).orElseThrow(()
                -> new ProductNotFoundException(String.format("Not found Product by this id %s", id)));
    }

    @GetMapping("/shop")
    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    @PostMapping("/all")
    public List<Product> findAllProductById(@RequestParam("id") List<Long> id){
        return productRepository.findAllById(id);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProductById(@PathVariable("id") Long id){
        productRepository.deleteById(id);
    }

    @PostMapping("/save")
    public Long saveProduct(@RequestBody @Valid ProductInput productInput){
//        Product product = new Product();
//        product.setTitle(productInput.getTitle());
//        product.setPrice(productInput.getPrice());
        Product product = ProductInputMapper.MAPPER.toProduct(productInput);
        return productRepository.save(product).getId();
    }

    @GetMapping("/cart")
    public List<CartProduct> cartProduct(){
        return cartRepository.findAll();
    }

    @GetMapping("/cart/delete/{id}")
    public void cartDeleteById(@PathVariable("id") Long id){
        cartRepository.deleteById(id);
    }

    @PostMapping("/cart/add")
    public Long addToCart(@RequestBody @Valid ProductCartInput productCartInput) {
        Optional<Product> productOpt = productRepository.findById(productCartInput.getProduct_id());
        if (productOpt.isEmpty()) {
            throw new NoSuchElementException("Product_id not found");
        } else{
//            CartProduct cartProduct  = new CartProduct();

            CartProduct cartProduct = ProductCartInputMapper.MAPPER.toCartProduct(productCartInput);
            cartProduct.setProductId(productOpt.get());

            return cartRepository.save(cartProduct).getId();
        }
    }
}
