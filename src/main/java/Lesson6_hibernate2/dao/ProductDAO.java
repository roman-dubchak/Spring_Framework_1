package Lesson6_hibernate2.dao;

import Lesson6_hibernate2.entity.Product;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
public class ProductDAO {
// TODO
//    1. В базе данных необходимо реализовать возможность хранить информацию о покупателях (id, имя)
//    и товарах (id, название, стоимость). У каждого покупателя свой набор купленных товаров;
//    2. Для обеих сущностей создаете Dao классы. Работу с SessionFactory выносите во вспомогательный класс;
//    3. * Создаете сервис, позволяющий по id покупателя узнать список купленных им товаров,
//    и по id товара узнавать список покупателей этого товара;
//    4. ** Добавить детализацию по паре «покупатель — товар»: сколько стоил товар в момент покупки клиентом;
//    ВАЖНО И ОБЯЗАТЕЛЬНО! Dao классы и сервис должны являться Spring бинами (Вам нужен Spring Context без веб части).
//    Контроллеры создавать не надо.
//    ВАЖНО! Выкидываете код по подготовке данных и таблиц, и делаете отдельный скрипт и формируете базу заранее.
//    Покупателей и товары в базу складываете заранее, через код этого делать не надо (лишнее усложнение).
//    SQL-скрипт прикрепите к работе.


    public static class ProductFactory{
        private  EntityManagerFactory factory = new Configuration()
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
        } catch (NoResultException e){
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

    public List<Product> findAll(){
        return productFactory.manager.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    public static void main(String[] args) {
//        findById(1L);
    }
}
