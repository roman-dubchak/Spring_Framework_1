package Lesson3_MVC_WEB_Start.servies;

import Lesson3_MVC_WEB_Start.entities.Product;
import Lesson3_MVC_WEB_Start.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getListProducts(){
       return productRepository.getListProduct();
    }

    public Product getProductByID(Integer id){
        return productRepository.getProduct(id);
    }

    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }
}
