package Lesson7_hibernate3.repo;

import Lesson7_hibernate3.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends CrudRepository<Product, Long> {
}
