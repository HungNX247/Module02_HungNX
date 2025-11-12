import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryProductRepository implements IProductRepository {
    private final List<Product> products = new ArrayList<>();
    private final AtomicInteger nextID = new AtomicInteger(1);

    private void simulateLatency() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Delay simulation error: " + e.getMessage());
        }
    }

    public InMemoryProductRepository() {
        for (int i = 0; i < 22; i++) {
            products.add(new Product(nextID.getAndIncrement(), "Laptop Gaming X" + i, 20000000.0 + (i * 1000000),
                    "High performance, suitable for gaming and work"));
        }
    }

    @Override
    public Product add(Product product) {
        simulateLatency();
        product.setId(nextID.getAndIncrement());
        products.add(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        simulateLatency();
        Product found = null;
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                found = p;
                break;
            }
        }

        if (found != null) {
            found.setName(product.getName());
            found.setPrice(product.getPrice());
            found.setDescription(product.getDescription());
            return found;
        }
        return null;
    }

    @Override
    public Optional<Product> findById(int id) {
        simulateLatency();
        for (Product product : products) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();

    }

    @Override
    public List<Product> findAll() {
        simulateLatency();
        return new ArrayList<>(products);
    }

    @Override
    public boolean delete(int id) {
        simulateLatency();
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        simulateLatency();
        return products.size();
    }

    @Override
    public List<Product> search(String query) {
        simulateLatency();
        List<Product> result = new ArrayList<>();
        if (query == null || query.trim().isEmpty()) {
            return result;
        }

        for (Product product : products) {
            String name = product.getName().toLowerCase();
            String desc = product.getDescription().toLowerCase();

            if (name.contains(query.trim().toLowerCase()) || desc.contains(query.trim().toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

}
