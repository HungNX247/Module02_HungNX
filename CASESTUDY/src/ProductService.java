
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

record PaginationResult(List<Product> products, int currentPage, int totalPages, int totalItems) {
}

public class ProductService {
    private final IProductRepository repository;
    private final int pageSize = 5;
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9 ]{3,50}$");

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    private void validateProduct(Product product) {
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Ten san pham khong duoc de trong!");
        }

        if (!NAME_PATTERN.matcher(product.getName()).matches()) {
            throw new IllegalArgumentException("Ten san pham phai tu 3-50 ky tu, chi chua chu cai, so va dau cach.");
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

    public List<Product> searchProducts(String query) throws Exception {
        return repository.search(query);
    }

    public List<Product> sortProducts(List<Product> products, String sortString) {
        String[] parts = sortString.toUpperCase().split(":");
        String criteria = parts[0];
        String direction = parts.length > 1 ? parts[1] : "ASC";
        Comparator<Product> comparator;

        switch (criteria) {
            case "ID":
                comparator = Comparator.comparingInt(Product::getId);
                break;
            case "NAME":
                comparator = Comparator.comparing(Product::getName);
                break;
            case "PRICE":
                comparator = Comparator.comparingDouble(Product::getPrice);
                break;
            case "DATE":
                comparator = Comparator.comparing(Product::getProductionDate);
                break;
            default:
                comparator = Comparator.naturalOrder();
        }

        if ("DESC".equalsIgnoreCase(direction)) {
            comparator = comparator.reversed();
        }
        return products.stream().sorted(comparator).collect(Collectors.toList());
    }

    public List<Product> filterProductsByPrice(double minPrice, double maxPrice) throws Exception {
        List<Product> allProducts = repository.findAll();
        List<Product> result = new ArrayList<>();

        for (Product product : allProducts) {
            double price = product.getPrice();

            if (price >= minPrice && price <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    public PaginationResult getPaginatedProducts(int page, String sortString) throws Exception {
        List<Product> allProducts = repository.findAll();
        List<Product> sortedProducts = sortProducts(allProducts, sortString);
        int totalItems = sortedProducts.size();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        if (page < 1) {
            page = 1;
        }

        if (totalPages > 0 && page > totalPages) {
            page = totalPages;
        }

        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, totalItems);

        List<Product> paginatedList = sortedProducts.subList(start, end);

        return new PaginationResult(paginatedList, page, totalPages, totalItems);
    }
}
