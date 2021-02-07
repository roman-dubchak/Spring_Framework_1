package Lesson6_hibernate2.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "product_buy")
@NamedQueries(
        @NamedQuery(name = "Product.findAll", query = "select p from Product p"))
@Component
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "title", length = 128)
    private String title;

    @Column(name = "price")
    private int price;

    @Column(name = "created_date", updatable=false)
    @CreationTimestamp
    private Timestamp created_at;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
//    Изначально наоборот сделал
//    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    List<Client> clientList;
//
//    public List<Client> getClientList() {
//        return clientList;
//    }
//
//    public void setClientList(List<Client> clientList) {
//        this.clientList = clientList;
//    }

    public Product() {
    }

    public Product(Long id, String title, int price, Timestamp created_at) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product: id %d, title %s, price %d.", id, title, price);
    }
}
