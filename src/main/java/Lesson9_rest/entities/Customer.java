package Lesson9_rest.entities;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customer_liq")
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @ColumnDefault("random_uuid()")
    @Column(name = "id")
    private UUID id;

    @Column (name = "firstname")
    private String firstname;

    @Column (name = "lastname")
    private String lastname;

    @Column (name = "city")
    private String city;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Customer(UUID id, String firstName, String lastName, String city) {
        this.id = UUID.randomUUID();
        this.firstname = firstName;
        this.lastname = lastName;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
