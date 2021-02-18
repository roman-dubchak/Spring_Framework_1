package Lesson10_rest_cart.entities;

import javax.persistence.*;

@Entity
@Table(name = "cart_product")
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product productId;

    public Product getProductId() {
        return productId;
    }

    public CartProduct(Long id, Product productId) {
        this.id = id;
        this.productId = productId;
    }

    public CartProduct() {
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("CartProduct id %s, product %s", id, productId);
    }
}
