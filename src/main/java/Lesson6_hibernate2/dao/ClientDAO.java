package Lesson6_hibernate2.dao;

import Lesson6_hibernate2.entity.Client;
import Lesson6_hibernate2.entity.Product;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientDAO {

    public static class ClientFactory {
        private EntityManagerFactory factory = new Configuration()
                .configure("hibernate2.xml")
                .buildSessionFactory();

        private EntityManager manager = factory.createEntityManager();

    }

    private static ClientFactory clientFactory = new ClientFactory();

    public void deleteById(Long id) {
        clientFactory.manager.getTransaction().begin();
        Query query = clientFactory.manager.createQuery("delete from Client where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        clientFactory.manager.getTransaction().commit();
    }

    public Client findById(Long id) {
        Query query = clientFactory.manager.createQuery("select c from Client c where c.id = :id");
        query.setParameter("id", id);
        Client client;
        try {
            client = (Client) query.getSingleResult();
            System.out.println("Find " + client);
        } catch (NoResultException e) {
            System.out.println("Not find product by id: " + id);
            client = new Client();
        }
        return client;
    }

    public Client saveOrUpdate(Client client) {
        clientFactory.manager.getTransaction().begin();
        clientFactory.manager.merge(client);
        clientFactory.manager.getTransaction().commit();
        return client;
    }

    public List<Client> findAllClients() {
        return clientFactory.manager.createNamedQuery("Client.findAll", Client.class).getResultList();
    }

    public static void main(String[] args) {
//        findById(1L);
    }
}
