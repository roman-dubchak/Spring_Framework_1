package Lesson5_hibernate;

import Lesson5_hibernate.entity.Product;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProductDAO {
// TODO
//  1. Создайте сущность Product (Long id, String title, int price)
//  и таблицу в базе данных для хранения объектов этой сущности;
//  2. Создайте класс ProductDao и реализуйте в нем логику выполнения CRUD-операций над сущностью Product
//  (Product findById(Long id)(Method find),
//  + List<Product> findAll()(JPQL),
//  void deleteById(Long id),
//  Product saveOrUpdate(Product product)).

    private static EntityManagerFactory factory = new Configuration()
            .configure("hibernate.xml")
            .buildSessionFactory();

    private static EntityManager manager = factory.createEntityManager();

    public static void main(String[] args) {
//        EntityManagerFactory factory = new Configuration()
//                .configure("hibernate.xml")
//                .buildSessionFactory();
//
//        EntityManager manager = factory.createEntityManager();

        Product apple = new Product(1L, "Apple", 55);
        addProduct(apple);

        saveOrUpdate(apple);
        findById(1L);
        deleteById(2L);

        findAll().stream().forEach(p->System.out.println(p.toString()));

    }

    private static void deleteById(Long id) {

    }

    private static Product findById(Long id) {

        return new Product ();
    }

    public static void addProduct(Product product){
        manager.getTransaction().begin();
        manager.persist(product);
        manager.getTransaction().commit();

    }

    public static Product saveOrUpdate(Product product) {
        manager.getTransaction().begin();
        Product newProduct = (Product) manager.createQuery(
                "select p from Product p where id = :id")
                .getSingleResult();
        manager.getTransaction().commit();
        return product;
    }

    public static List<Product> findAll(){
        return manager.createNamedQuery("Product.findAll", Product.class).getResultList();
    }
}
