import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private double price;
    private String description;
    private LocalDate productionDate;

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Constructor đầy đủ
    public Product(int id, String name, double price, String description, LocalDate productionDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.productionDate = productionDate;
    }

    // Getters / Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public LocalDate getProductionDate() { return productionDate; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setProductionDate(LocalDate productionDate) { this.productionDate = productionDate; }

    // Để ghi ra file
    public String toCsvString() {
    String dateStr = productionDate != null ? productionDate.format(DATE_FORMATTER) : "";
    return id + "|" 
            + name + "|" 
            + String.format("%.0f", price) + "|" 
            + description + "|" 
            + dateStr;
}


    @Override
    public String toString() {
        String dateStr = productionDate != null ? productionDate.format(DATE_FORMATTER) : "";

        // Rút gọn mô tả để bảng gọn hơn (giống hình bạn gửi)
        String shortDesc = description;
        if (shortDesc != null && shortDesc.length() > 30) {
            shortDesc = shortDesc.substring(0, 27) + "...";
        }

        // Chú ý width cho từng cột để khớp với header bạn đã in
        return String.format(
                "| %-4d | %-25s | %-12.2f | %-40s | %-12s |",
                id, name, price, shortDesc, dateStr
        );
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(this.id, o.id);
    }
}
