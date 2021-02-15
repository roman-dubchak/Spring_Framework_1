package Lesson5_hibernate;

import Lesson5_hibernate.entity.Product;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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
        Product apple = new Product(1L, "Apple", 55);
        Product orange = new Product(2L, "Orange", 65);
        Product tomato = new Product(3L, "Tomato", 105);
        saveOrUpdate(apple);
        saveOrUpdate(orange);
        saveOrUpdate(tomato);

        findById(2l);
        deleteById(5L);
        List<Product> productList = findAll();
        productList.stream().forEach(p -> System.out.println(p.toString()));

    }

    private static void deleteById(Long id) {
        manager.getTransaction().begin();
        Query query = manager.createQuery("delete from Product where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        manager.getTransaction().commit();
    }

    private static Product findById(Long id) {
        Query query = manager.createQuery("select p from Product p where p.id = :id");
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

    /*    добавлние через persist но была ошибка
        Exception in thread "main" javax.persistence.PersistenceException:
        org.hibernate.PersistentObjectException: detached entity passed to persist: Lesson5_hibernate.entity.Product
        public static void addProduct(Product product){
            manager.getTransaction().begin();
            manager.persist(product);
            manager.getTransaction().commit();
        }
    */
    public static Product saveOrUpdate(Product product) {
/*        Здесь обновление
        manager.getTransaction().begin();
        Product newProduct = (Product) manager.createQuery(
                "select p from Product p where id = 1L")
                .getSingleResult();
        newProduct.setTitle("Banana");
        manager.getTransaction().commit();
*/
        manager.getTransaction().begin();
        manager.merge(product);
        manager.getTransaction().commit();
        return product;
    }

    public static List<Product> findAll() {
        return manager.createNamedQuery("Product.findAll", Product.class).getResultList();
    }
}
