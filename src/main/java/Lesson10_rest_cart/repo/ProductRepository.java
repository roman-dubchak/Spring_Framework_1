package Lesson10_rest_cart.repo;

import com.gb.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


//    default Page<Product> findPaginated(int pageNo, int pageSize){
//        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
//        return this.findAll(pageable);
//    };
}
