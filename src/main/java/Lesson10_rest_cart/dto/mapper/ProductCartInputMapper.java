package Lesson10_rest_cart.dto.mapper;

import Lesson10_rest_cart.dto.ProductCartInput;
import Lesson10_rest_cart.entities.CartProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductCartInputMapper {
    ProductCartInputMapper MAPPER = Mappers.getMapper(ProductCartInputMapper.class);

//    @Mapping(target = "productId", source = "productCartInput.product_id")
    CartProduct toCartProduct(ProductCartInput productCartInput);



}
