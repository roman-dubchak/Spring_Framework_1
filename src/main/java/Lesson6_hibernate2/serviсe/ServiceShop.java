package Lesson6_hibernate2.serviсe;

import Lesson6_hibernate2.dao.ClientDAO;
import Lesson6_hibernate2.dao.ProductDAO;
import org.springframework.stereotype.Service;

@Service
public class ServiceShop {
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

        // метод findAllClientByIdProduct
    }

}
