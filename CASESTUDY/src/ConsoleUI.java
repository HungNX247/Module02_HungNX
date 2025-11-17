import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleUI {
    private static final Scanner scanner = new Scanner(System.in);
    private final ProductService service;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ConsoleUI(ProductService service) {
        this.service = service;
    }

    private int readIntInput(String prompt) {
        int result = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            try {
                result = scanner.nextInt();
                scanner.nextLine();
                isValid = true;
            } catch (InputMismatchException e) {
                System.err.println("Lỗi: Vui lòng nhập số nguyên hợp lệ");
                scanner.nextLine();
            }
        }
        return result;
    }

    private double readDoubleInput(String prompt, double defaultValue) {
        double result = defaultValue;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                isValid = true;
                continue;
            }
            try {
                result = Double.parseDouble(input);
                if (result < 0) {
                    throw new NumberFormatException();
                }
                isValid = true;
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Giá phải là một số dương hợp lệ.");
            }
        }
        return result;
    }

    private LocalDate readDateInput(String prompt, LocalDate defaultValue) {
        LocalDate result = defaultValue;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                isValid = true;
                continue;
            }
            try {
                result = LocalDate.parse(input, DATE_FORMATTER);
                isValid = true;
            } catch (DateTimeParseException e) {
                System.err.println("Loi: Ngày tháng không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
            }
        }
        return result;
    }

    public void run() {
        int choice;
        do {
            showMenu();
            System.out.print("Lựa chọn chức năng: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Vui lòng chỉ nhập số cho lựa chọn chức năng.");
                scanner.nextLine();
                choice = -1;
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        showProduct();
                        break;
                    case 2:
                        createProduct();
                        break;
                    case 3:
                        updateProduct();
                        break;
                    case 4:
                        deleteProduct();
                        break;
                    case 5:
                        searchProduct();
                        break;
                    case 6:
                        filterProduct();
                        break;
                    case 0:
                        System.out.println("--- Đang lưu dữ liệu lần cuối và thoát ---");
                        ProductRepository.getInstance().saveAll();
                        System.out.println("Tạm biệt! Ứng dụng kết thúc. ");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. ");
                }
            } catch (Exception e) {
                System.err.println("\n--- LỖI HỆ THỐNG/NGHIỆP VỤ ---");
                System.err.println("Xử lý thất bại: " + e.getMessage());
                System.err.println("------------------------------\n");
            }
        } while (choice != 0);
    }

    private void filterProduct() throws Exception {
        System.out.println("\n--- LỌC SẢN PHẨM THEO KHOẢNG GIÁ ---");

        double minPrice = readDoubleInput("Nhập giá tối thiểu (0 để trống): ", 0.0);
        double maxPrice = readDoubleInput("Nhập giá tối đa (0 để trống): ", 999999999.0);

        if (minPrice > maxPrice) {
            System.err.println("Lỗi: Giá tối thiểu không được lớn hơn giá tối đa.");
            return;
        }

        System.out.printf("--- Đang lọc sản phẩm từ %.2f đến %.2f ---\n", minPrice, maxPrice);

        List<Product> filteredResults = service.filterProductsByPrice(minPrice, maxPrice);

        displayProductList(filteredResults, "KẾT QUẢ LỌC THEO KHOẢNG GIÁ");
    }

    private void updateProduct() throws Exception {
        System.out.println("\n--- CẬP NHẬT SẢN PHẨM ---");
        int id = readIntInput("Nhập ID sản phẩm cần cập nhật: ");
        System.out.println("--- Đang tìm sản phẩm ---");
        Optional<Product> optionalProduct = service.getById(id);

        if (optionalProduct.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm có ID: " + id);
            return;
        }

        Product existingProduct = optionalProduct.get();
        System.out.println("Đang chỉnh sửa sản phẩm: " + existingProduct.getName());

        System.out.print("Tên mới (Để trống nếu không đổi: " + existingProduct.getName() + " ): ");
        String name = scanner.nextLine();

        double currentPrice = existingProduct.getPrice();
        double price = readDoubleInput("Giá mới (De trong neu khong doi: " + currentPrice + ")", currentPrice);

        System.out.print("Mô tả mới (Để trống nếu không đổi: " + existingProduct.getDescription() + " ): ");
        String descrition = scanner.nextLine();

        LocalDate currentDate = existingProduct.getProductionDate();
        LocalDate date = readDateInput(
                "Ngày sản xuất mới (Để trống nếu không đổi: " + currentDate.format(DATE_FORMATTER) + ")", currentDate);

        existingProduct.setName(name.trim().isEmpty() ? existingProduct.getName() : name);
        existingProduct.setPrice(price);
        existingProduct.setDescription(descrition.trim().isEmpty() ? existingProduct.getDescription() : descrition);
        existingProduct.setProductionDate(date);

        System.out.println("--- Đang cập nhật ---");
        service.save(existingProduct);
        System.out.println("THÀNH CÔNG: Đã cập nhật sản phẩm ID: " + id);

    }

    private void deleteProduct() throws Exception {
        System.out.println("\n--- XÓA SẢN PHẨM ---");
        int id = readIntInput("Nhập ID sản phẩm cần xóa: ");
        System.out.print("Bạn có chắc muốn xóa sản phẩm ID " + id + "? (Y/N): ");
        String confirm = scanner.nextLine().trim().toUpperCase();

        if (confirm.equals("Y")) {
            System.out.println("--- Đang xóa ---");
            if (service.delete(id)) {
                System.out.println("\n* THÀNH CÔNG: Đã xóa sản phẩm ID: " + id);
            } else {
                System.out.println("\n* THẤT BẠI: Không tìm thấy sản phẩm ID: " + id);
            }
        } else {
            System.out.println("Đã hủy thao tác xóa.");
        }
    }

    private void searchProduct() throws Exception {
        System.out.println("\n--- TÌM KIẾM SẢN PHẨM ---");
        System.out.print("Nhập ID (số) hoặc Tên/Mô tả (chữ) để tìm kiếm: ");
        String query = scanner.nextLine().trim();

        if (query.isEmpty()) {
            System.out.println("Vui lòng nhập từ khóa tìm kiếm.");
            return;
        }

        try {
            int id = Integer.parseInt(query);
            System.out.printf("--- Đang tìm kiếm sản phẩm theo ID '%d' ---\n", id);

            Optional<Product> optionalProduct = service.getById(id);

            if (optionalProduct.isPresent()) {
                displayProductList(List.of(optionalProduct.get()), "KẾT QUẢ TÌM KIẾM THEO ID");
            } else {
                System.out.println("\n--- KẾT QUẢ TÌM KIẾM THEO ID ---");
                System.out.println("Không tìm thấy sản phẩm có ID: " + id);
            }
        } catch (NumberFormatException e) {
            System.out.printf("--- Đang tìm kiếm sản phẩm theo từ khóa '%s' ---", query);

            List<Product> searchResults = service.searchProducts(query);
            displayProductList(searchResults, "KẾT QUẢ TÌM KIẾM THEO TÊN/MÔ TẢ");
        }
    }

    private void createProduct() throws Exception {
        System.out.println("\n--- THÊM SẢN PHẨM MỚI ---");
        System.out.print("Tên sản phẩm: ");
        String name = scanner.nextLine();

        double price = readDoubleInput("Giá (VNĐ): ", 0.0);

        System.out.print("Mô tả: ");
        String description = scanner.nextLine();

        LocalDate date = readDateInput("Ngày sản xuất (dd/MM/yyyy): ", LocalDate.now());

        Product newProduct = new Product(0, name, price, description, date);
        System.out.println("--- Đang thêm sản phẩm ---");
        Product saveProduct = service.save(newProduct);
        System.out.println("\n* THÀNH CÔNG: Đã thêm sản phẩm ID: " + saveProduct.getId());

    }

    private void showProduct() throws Exception {
        String sortCriteria = "ID:ASC";
        int currentPage = 1;
        int totalPages;

        do {
            System.out.println("\n---Sắp xếp hiện tại: " + sortCriteria.toUpperCase() + " ---");
            System.out.printf("\n--- Đang tải dữ liệu trang %d ---\n", currentPage);
            PaginationResult result = service.getPaginatedProducts(currentPage, sortCriteria);
            List<Product> products = result.products();
            totalPages = result.totalPages();

            displayProductList(products, "DANH SÁCH SẢN PHẨM: ");

            if (products.isEmpty() && result.totalItems() > 0) {
                currentPage = 1;
                continue;
            } else if (result.totalItems() == 0) {
                return;
            }

            System.out.printf("Trang: %d/%d (Tổng sản phẩm: %d)\n",
                    result.currentPage(), totalPages, result.totalItems());

            System.out.println("Các tiêu chí: [ID], [NAME], [PRICE], [DATE]");
            System.out.println("Cú pháp sắp xếp: CRITERIA[:DIRECTION]. VD: PRICE:DESC, NAME:ASC (Mặc định là ASC)");

            System.out.print("Nhập [T]Trang sau, [P]Trang trước, [S]Số trang, [C]Chọn sắp xếp hoặc [Q]Quay lại: ");
            String action = scanner.nextLine().trim().toUpperCase();

            switch (action) {
                case "T":
                    currentPage = Math.min(currentPage + 1, totalPages);
                    break;
                case "P":
                    currentPage = Math.max(currentPage - 1, 1);
                    break;
                case "Q":
                    return;
                case "C":
                    System.out.print("Nhập tiêu chí sắp xếp và hướng (ID/NAME/PRICE/DATE[:ASC/DESC]): ");
                    String newCriteria = scanner.nextLine().trim();
                    if (!newCriteria.isEmpty()) {
                        sortCriteria = newCriteria.toUpperCase().trim();
                        currentPage = 1;
                        break;
                    }

                default:
                    try {
                        int newPage = Integer.parseInt(action);
                        if (newPage >= 1 && newPage <= totalPages) {
                            currentPage = newPage;
                        } else {
                            System.out.println("Số trang không hợp lệ. Vui lòng nhập lại");
                        }
                    } catch (NumberFormatException e) {
                        if (!action.isEmpty()) {
                            System.out.println("Lựa chọn không hợp lệ!");
                        }
                    }
                    break;
            }
        } while (true);
    }

    private void showMenu() {
        System.out.println("\n=============================================");
        System.out.println("  QUẢN LÝ SẢN PHẨM E-COMMERCE ");
        System.out.println("=============================================");
        System.out.println("1. Xem danh sách sản phẩm (Có Phân Trang)");
        System.out.println("2. Thêm sản phẩm mới (CRUD - Create)");
        System.out.println("3. Cập nhật sản phẩm (CRUD - Update)");
        System.out.println("4. Xóa sản phẩm (CRUD - Delete)");
        System.out.println("5. Tìm kiếm Sản phẩm");
        System.out.println("6. Lọc Sản phẩm theo Giá (Filter)");
        System.out.println("0. Thoát");
        System.out.println("=============================================");
    }

    private void printHeader() {
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf(
                "| %-4s | %-25s | %-12s | %-41s | %-14s |\n",
                "ID", "Tên Sản Phẩm", "Giá (VNĐ)", "Mô tả", "Ngày sản xuất");

        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------");
    }

    private void displayProductList(List<Product> products, String title) {
        System.out.println("\n--- " + title + " ---");
        if (products.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào.");
            return;
        }

        printHeader();
        for (Product p : products) {
            System.out.println(p.toString());
        }
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------");

    }
}
