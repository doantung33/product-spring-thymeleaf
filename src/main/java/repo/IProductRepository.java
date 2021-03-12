package repo;

import model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
    @Query(value = "select * from product where name like ?",nativeQuery = true)
    List<Product>search(String name);
}
