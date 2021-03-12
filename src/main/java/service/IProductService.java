package service;

import model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product>findAll();
    Page<Product>findAll(Pageable pageable);
    Product findById(Long id);
    Product save(Product product);
    void delete(Long id);
    List<Product>findByName(String name);

}
