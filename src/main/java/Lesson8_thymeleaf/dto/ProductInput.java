package Lesson8_thymeleaf.dto;

import javax.validation.constraints.NotBlank;

public class ProductInput {
    @NotBlank
    private String title;
    private Integer price;

    public ProductInput(String title, Integer price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
