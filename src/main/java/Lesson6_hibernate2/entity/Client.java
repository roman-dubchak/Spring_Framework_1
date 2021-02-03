package Lesson6_hibernate2.entity;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@NamedQueries(
        @NamedQuery(name = "Client.findAll", query = "select c from Client c"))
@Component
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column (name = "name", length = 128, nullable = false)
    private String name;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    public Client() {
    }

    @Override
    public String toString() {
        return String.format("Client: id - %d, name - %s, product id.", id, name);
    }

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
