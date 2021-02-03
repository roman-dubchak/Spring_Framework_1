package Lesson6_hibernate2.serviсe;

import Lesson6_hibernate2.dao.ClientDAO;
import Lesson6_hibernate2.dao.ProductDAO;
import Lesson6_hibernate2.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceShop {

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

    private static ProductDAO productDAO = null;
    private static ClientDAO clientDAO = null;

    public ServiceShop(ProductDAO productDAO, ClientDAO clientDAO) {
        this.productDAO = productDAO;
        this.clientDAO = clientDAO;
    }

    public static ProductDAO getProductDAO() {
        return productDAO;
    }

    public static void setProductDAO(ProductDAO productDAO) {
        ServiceShop.productDAO = productDAO;
    }

    public static ClientDAO getClientDAO() {
        return clientDAO;
    }

    public static void setClientDAO(ClientDAO clientDAO) {
        ServiceShop.clientDAO = clientDAO;
    }

    public ServiceShop() {
    }

    public static void main(String[] args) {
        productDAO = new ProductDAO();
        productDAO.findById(1L);
        // метод findAllProductByIdClient
        clientDAO = new ClientDAO();
        clientDAO.findById(1L);

//        findAllProductByIdClient(1L);


        // метод findAllClientByIdProduct
    }

//    private static List<Product> findAllProductByIdClient(Long idClient) {
//        productDAO.findAllProducts();
//
//
//        return List<Product>;
//    }

}
