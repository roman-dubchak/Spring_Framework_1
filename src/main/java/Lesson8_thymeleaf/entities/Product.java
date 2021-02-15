package Lesson8_thymeleaf.entities;

import javax.persistence.*;

@Entity
@Table(name = "product_liq")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    public Product(Long id, String title, Integer cost) {
        this.id = id;
        this.title = title;
        this.price = cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Product: id - %d; title - %s; price - %d\n.",id, title, price);
    }
}
