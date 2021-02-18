package Lesson10_rest_cart.dto.mapper;

import Lesson10_rest_cart.dto.ProductInput;
import Lesson10_rest_cart.entities.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductInputMapper {
    ProductInputMapper MAPPER = Mappers.getMapper(ProductInputMapper.class);

    Product toProduct(ProductInput productInput);

    @InheritInverseConfiguration
    ProductInput fromProduct(Product product);

}
