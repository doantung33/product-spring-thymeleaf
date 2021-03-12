package service;

import model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IService<Product> {
    Page<Product>findAll(Pageable pageable);
    List<Product>findByName(String name);
    List<Product>productNew();
    List<Product>dateProductNew();

}
