package Lesson10_rest_cart.dto;


import javax.validation.constraints.Min;

public class ProductCartInput {
    @Min(value = 1)
    private Long product_id;

       /* dd.MM.yyyy, MM.dd.yyyy
    @NotNull,
    @Size
    @Min
    @Max
     */

//    @AssertTrue (message = "product_id должно быть больше 0")
//    public boolean isTest() {
//        return product_id > 0;
//    }
    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public ProductCartInput(Long product_id) {
        this.product_id = product_id;
    }

    public ProductCartInput() {
    }
}
