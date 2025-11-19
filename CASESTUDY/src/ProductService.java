
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
            throw new IllegalArgumentException("Tên sản phẩm không được để trống!");
        }

        if (!NAME_PATTERN.matcher(product.getName()).matches()) {
            throw new IllegalArgumentException("Tên sản phẩm phải từ 3-50 ký tự, chỉ chứa chữ cái, số và dấu cách.");
        }

        double price = product.getPrice();
        if (Double.isNaN(price) || Double.isInfinite(price)) {
            throw new IllegalArgumentException("Giá sản phẩm không hợp lệ!");
        }

        if (price < 0) {
            throw new IllegalArgumentException("Giá sản phẩm phải là số dương!");
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
        if (products == null || products.isEmpty())
            return products;

        String[] parts = sortString.toUpperCase().trim().split(":");
        String criteria = parts[0].trim();
        String direction = parts.length > 1 ? parts[1].trim() : "ASC";

        Comparator<Product> comparator;

        switch (criteria) {
            case "ID":
                comparator = Comparator.comparingInt(Product::getId);
                break;
            case "NAME":
                comparator = Comparator.comparing(
                        p -> p.getName().toLowerCase());
                break;
            case "PRICE":
                comparator = Comparator.comparingDouble(Product::getPrice);
                break;
            case "DATE":
                comparator = Comparator.comparing(Product::getProductionDate);
                break;
            default:
                comparator = Comparator.comparingInt(Product::getId);
        }

        if ("DESC".equalsIgnoreCase(direction)) {
            comparator = comparator.reversed();
        }

        return products.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
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
