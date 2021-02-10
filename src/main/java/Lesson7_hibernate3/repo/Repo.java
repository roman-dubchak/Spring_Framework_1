package Lesson7_hibernate3.repo;

import Lesson7_hibernate3.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Product, Long> {

    //    default Page<Product> findPaginated(int pageNo, int pageSize){
//        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
//        return this.findAll(pageable);
//    };
}
