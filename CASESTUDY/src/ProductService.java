
import java.util.List;
import java.util.Optional;

record PaginationResult(List<Product> products, int currentPage, int totalPages, int totalItems) {
}

public class ProductService {
    private final IProductRepository repository;
    private final int pageSize = 5;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    private void validateProduct(Product product) {
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Ten san pham khong duoc de trong!");
        }

        double price = product.getPrice();
        if (Double.isNaN(price) || Double.isInfinite(price)) {
            throw new IllegalArgumentException("Gia san pham khong hop le!");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Gia san pham phai la so duong!");
        }
    }

    public Product save(Product product) throws Exception {
        validateProduct(product);
        if (product.getId() == 0) {
            return repository.add(product);
        } else {
            return repository.update(product);
        }
    }

    public Optional<Product> getById(int id) throws Exception {
        return repository.findById(id);
    }

    public boolean delete(int id) throws Exception {
        return repository.delete(id);
    }

    public List<Product> seaProducts(String query) throws Exception {
        return repository.search(query);
    }

    public PaginationResult getpaginatedProducts(int page) throws Exception {
        List<Product> allProducts = repository.findAll();
        int totalItems = allProducts.size();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        if (page < 1) {
            page = 1;
        }

        if (totalPages > 0 && page > totalPages) {
            page = totalPages;
        }

        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, totalItems);

        List<Product> paginatedList = allProducts.subList(start, end);

        return new PaginationResult(paginatedList, page, totalPages, totalItems);
    }
}
