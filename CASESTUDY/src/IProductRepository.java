import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    Product add(Product product) throws Exception;

    Product update(Product product) throws Exception;

    Optional<Product> findById(int id) throws Exception;

    List<Product> findAll() throws Exception;

    boolean delete(int id) throws Exception;

    int count() throws Exception;

    List<Product> search(String query) throws Exception;
}
