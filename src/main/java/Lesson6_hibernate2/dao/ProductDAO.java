package Lesson6_hibernate2.dao;

import Lesson6_hibernate2.entity.Client;
import Lesson6_hibernate2.entity.Product;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductDAO {

    public static class ProductFactory {
        private EntityManagerFactory factory = new Configuration()
                .configure("hibernate2.xml")
                .buildSessionFactory();

        private EntityManager manager = factory.createEntityManager();

        public EntityManager getManager() {
            return manager;
        }

        public void setManager(EntityManager manager) {
            this.manager = manager;
        }
    }

    private static ProductFactory productFactory = new ProductFactory();

    public void deleteById(Long id) {
        productFactory.manager.getTransaction().begin();
        Query query = productFactory.manager.createQuery("delete from Product where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        productFactory.manager.getTransaction().commit();
    }

    public Product findById(Long id) {
        Query query = productFactory.manager.createQuery("select p from Product p where p.id = :id");
        query.setParameter("id", id);
        Product product;
        try {
            product = (Product) query.getSingleResult();
            System.out.println("Find " + product);
        } catch (NoResultException e) {
            System.out.println("Not find product by id: " + id);
            product = new Product();
        }
        return product;
    }

    public Product saveOrUpdate(Product product) {
        productFactory.manager.getTransaction().begin();
        productFactory.manager.merge(product);
        productFactory.manager.getTransaction().commit();
        return product;
    }

    public List<Product> findAllProducts() {
        return productFactory.manager.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    // Здесь сибираем лист лонгов - id продуктов
    public List<Long> findAllProductByIdClient(Long idClient) {
        Query query = productFactory.manager.createQuery("select id from Product where client_id = :id");
        query.setParameter("id", idClient);
        List<Long> productIdList;
        try {
            productIdList = query.getResultList();
            System.out.println(productIdList);
        } catch (NoResultException e) {
            System.out.println("Not find list product by id: " + idClient);
            productIdList = new ArrayList<>();
        }
        return productIdList;
    }

    // Здесь списко клиентов, но по сути получается достать только 1 клиента
    // Пытался использовать запрос select id from product_buy where client_id = 1;
    // но нельзя создать поле client_id, так как уже указано как вшешний ключ в JOIN
    public List<Long> findAllClientByIdProduct(Long id) {
        Product product = findById(id);
        List<Long> clientIdtList = new ArrayList<>();
        clientIdtList.add(product.getClient().getId());
        System.out.println("productList: " + clientIdtList);
        return clientIdtList;
    }

}
