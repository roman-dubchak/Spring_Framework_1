package Lesson9_rest.dto;

import javax.validation.constraints.NotBlank;

public class CustomerInput {
    @NotBlank
    private String firstName;
    private String lastName;
    private String city;

//    Нужен ли в DTO объекте конструктор?
    public CustomerInput(@NotBlank String firstName, String lastName, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
