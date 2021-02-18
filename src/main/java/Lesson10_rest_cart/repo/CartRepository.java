package Lesson10_rest_cart.repo;

import Lesson10_rest_cart.entities.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartProduct, Long> {

}
