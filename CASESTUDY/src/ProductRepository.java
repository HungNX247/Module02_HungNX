import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductRepository implements IProductRepository {
    private static ProductRepository instance;

    private static final String FILE_PATH = "product.txt";
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final int LATENCY_MS = 500;

    // Regex: cho phép mọi ký tự trừ '|' cho tên và mô tả
    private static final String PRODUCT_REGEX =
            "^\\d+\\|[^\\|]+\\|[0-9]+\\.?[0-9]*\\|[^\\|]*\\|\\d{2}/\\d{2}/\\d{4}$";
    private static final Pattern PATTERN = Pattern.compile(PRODUCT_REGEX);

    private final List<Product> products = new ArrayList<>();
    private final AtomicInteger nextID = new AtomicInteger(1);

    private ProductRepository() {
        loadDataFromFile();
    }

    public static synchronized ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    @SuppressWarnings("unused")
    private void simulateLatency() {
        if (LATENCY_MS <= 0) return;
        try {
            Thread.sleep(LATENCY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Loi mo phong do tre: " + e.getMessage());
        }
    }

    private void loadDataFromFile() {
        System.out.println("---Dang tai du lieu tu file " + FILE_PATH + "---");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                Matcher matcher = PATTERN.matcher(line);
                if (!matcher.matches()) {
                    System.err.println("Loi Regex: Bo qua dong du lieu khong hop le: " + line);
                    continue;
                }

                String[] parts = line.split("\\|", -1);

                if (parts.length == 5) {
                    try {
                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        double price = Double.parseDouble(parts[2]);
                        String description = parts[3];
                        LocalDate date = LocalDate.parse(parts[4], DATE_FORMATTER);

                        products.add(new Product(id, name, price, description, date));
                        nextID.set(Math.max(nextID.get(), id + 1));
                    } catch (NumberFormatException | java.time.format.DateTimeParseException e) {
                        System.err.println("Loi parse du lieu so/ngay thang: " + line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + FILE_PATH + " khong ton tai. Tao du lieu mau.");
            initializeSampleData();
        } catch (IOException e) {
            System.err.println("Loi doc file: " + e.getMessage());
        }
    }

    private void initializeSampleData() {
        for (int i = 1; i < 22; i++) {
            products.add(new Product(
                    nextID.getAndIncrement(),
                    "Laptop Gaming X" + i,
                    20000000.0 + (i * 1000000),
                    "High performance, suitable for gaming and work",
                    LocalDate.of(2024, 1, 1).plusMonths(i - 1)
            ));
        }
        try {
            saveAll();
        } catch (Exception e) {
            System.err.println("Loi luu du lieu mau: " + e.getMessage());
        }
    }

    @Override
    public Product add(Product product) throws Exception {
        simulateLatency();
        product.setId(nextID.getAndIncrement());
        products.add(product);
        saveAll();
        return product;
    }

    @Override
    public Product update(Product product) throws Exception {
        simulateLatency();
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setProductionDate(product.getProductionDate());
                saveAll();
                return p;
            }
        }
        // Thống nhất: ném Exception có kiểm tra (thay vì RuntimeException)
        throw new Exception("Cap nhat that bai: Khong tim thay ID san pham " + product.getId());
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
    public boolean delete(int id) throws Exception {
        simulateLatency();
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getId() == id) {
                products.remove(i);
                saveAll();
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
        if (query == null) return result;

        String keyword = query.trim().toLowerCase();
        if (keyword.isEmpty()) return result;

        for (Product product : products) {
            String name = product.getName().toLowerCase();
            String desc = product.getDescription().toLowerCase();

            if (name.contains(keyword) || desc.contains(keyword)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public void saveAll() throws Exception {
        simulateLatency();
        System.out.println("---Dang ghi du lieu vao file " + FILE_PATH + "---");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Product product : products) {
                bufferedWriter.write(product.toCsvString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new Exception("Loi I/O khi luu file " + e.getMessage());
        }
    }
}
