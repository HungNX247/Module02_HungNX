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
                System.err.println("Loi: Vui long nhap so nguyen hop le");
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
                System.err.println("Loi: Gia phai la mot so duong hop le.");
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
                System.err.println("Loi: Ngay thang khong hop le. Vui long nhap theo dinh dang dd/MM/yyyy.");
            }
        }
        return result;
    }

    public void run() {
        int choice;
        do {
            showMenu();
            System.out.print("Lua chon chuc nang: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Vui long chi nhap so cho lua chon chuc nang.");
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
                    System.out.println("--- Dang luu du lieu lan cuoi va thoat ---");
                    ProductRepository.getInstance().saveAll();
                        System.out.println("Tam biet! Ung dung ket thuc. ");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. ");
                }
            } catch (Exception e) {
                System.err.println("\n--- LOI HE THONG/NGHIEP VU ---");
                System.err.println("Xu ly that bai: " + e.getMessage());
                System.err.println("------------------------------\n");
            }
        } while (choice != 0);
    }

    private void filterProduct() throws Exception {
        System.out.println("\n--- LOC SAN PHAM THEO KHOANG GIA ---");

        double minPrice = readDoubleInput("Nhap Gia toi thieu (0 de trong): ", 0.0);
        double maxPrice = readDoubleInput("Nhap Gia toi da (0 de trong): ", 999999999.0);

        if (minPrice > maxPrice) {
            System.err.println("Loi: Gia toi thieu khong duoc lon hon gia toi da.");
            return;
        }

        System.out.printf("--- Dang loc san pham tu %.2f den %.2f ---\n", minPrice, maxPrice);

        List<Product> filteredResults = service.filterProductsByPrice(minPrice, maxPrice);

        displayProductList(filteredResults, "KET QUA LOC THEO KHOANG GIA");
    }

    private void updateProduct() throws Exception {
        System.out.println("\n--- CAP NHAT SAN PHAM ---");
        int id = readIntInput("Nhap ID san pham can cap nhat: ");
        System.out.println("--- Dang tim san pham ---");
        Optional<Product> optionalProduct = service.getById(id);

        if (optionalProduct.isEmpty()) {
            System.out.println("Khong tim thay san pham co ID: " + id);
            return;
        }

        Product existingProduct = optionalProduct.get();
        System.out.println("Dang chinh sua san pham: " + existingProduct.getName());

        System.out.print("Ten moi (De trong neu khong doi: " + existingProduct.getName() + " ): ");
        String name = scanner.nextLine();

        double currentPrice = existingProduct.getPrice();
        double price = readDoubleInput("Gia moi (De trong neu khong doi: " + currentPrice + ")", currentPrice);

        System.out.print("Mo ta moi (De trong neu khong doi: " + existingProduct.getDescription() + " ): ");
        String descrition = scanner.nextLine();

        LocalDate currentDate = existingProduct.getProductionDate();
        LocalDate date = readDateInput("Ngay san xuat moi (De trong neu khong doi: " + currentDate.format(DATE_FORMATTER) + ")", currentDate);

        existingProduct.setName(name.trim().isEmpty() ? existingProduct.getName() : name);
        existingProduct.setPrice(price);
        existingProduct.setDescription(descrition.trim().isEmpty() ? existingProduct.getDescription() : descrition);
        existingProduct.setProductionDate(date);

        System.out.println("--- Dang cap nhat ---");
        service.save(existingProduct);
        System.out.println("THANH CONG: Da cap nhat san pham ID: " + id);

    }

    private void deleteProduct() throws Exception {
        System.out.println("\n--- XOA SAN PHAM ---");
        int id = readIntInput("Nhap ID san pham can xoa: ");
        System.out.print("Ban co chac chan muon xoa san pham ID " + id + "? (Y/N): ");
        String confirm = scanner.nextLine().trim().toUpperCase();

        if (confirm.equals("Y")) {
            System.out.println("--- Dang xoa ---");
            if (service.delete(id)) {
                System.out.println("\n* THANH CONG: Da xoa san pham ID: " + id);
            } else {
                System.out.println("\n* THAT BAI: Khong tim thay san pham ID: " + id);
            }
        } else {
            System.out.println("Da huy thao tac xoa.");
        }
    }

    private void searchProduct() throws Exception {
        System.out.println("\n--- TIM KIEM SAN PHAM ---");
        System.out.print("Nhap ID (so) hoac Ten/Mo ta (chu) de tim kiem: ");
        String query = scanner.nextLine().trim();

        if (query.isEmpty()) {
            System.out.println("Vui long nhap tu khoa tim kiem.");
            return;
        }

        try {
            int id = Integer.parseInt(query);
            System.out.printf("--- Đang tìm kiếm sản phẩm theo ID '%d' ---\n", id);

            Optional<Product> optionalProduct = service.getById(id);

            if (optionalProduct.isPresent()) {
                displayProductList(List.of(optionalProduct.get()), "KET QUA TIM KIEM THEO ID");
            } else {
                System.out.println("\n--- KET QUA TIM KIEM THEO ID ---");
                System.out.println("Khong tim thay san pham co ID: " + id);
            }
        } catch (NumberFormatException e) {
            System.out.printf("--- Đang tìm kiếm sản phẩm theo từ khóa '%s' ---", query);

            List<Product> searchResults = service.seaProducts(query);
            displayProductList(searchResults, "KET QUA TIM KIEM THEO TEN/MO TA");
        }
    }

    private void createProduct() throws Exception {
        System.out.println("\n--- THEM SAN PHAM MOI ---");
        System.out.print("Ten san pham: ");
        String name = scanner.nextLine();

        double price = readDoubleInput("Gia (VND): ", 0.0) ;
        
        System.out.print("Mo ta: ");
        String description = scanner.nextLine();

        LocalDate date = readDateInput("Ngay san xuat (dd/MM/yyyy): ", LocalDate.now());

        Product newProduct = new Product(0, name, price, description, date);
        System.out.println("--- Dang them san pham ---");
        Product saveProduct = service.save(newProduct);
        System.out.println("\n* THANH CONG: Da them san pham ID: " + saveProduct.getId());

    }

    private void showProduct() throws Exception {
        String sortCriteria = "ID:ASC";
        int currentPage = 1;
        int totalPages;

        do {
            System.out.println("\n---Sap xep hien tai: " + sortCriteria.toUpperCase() + " ---");
            System.out.printf("\n--- Dang tai du lieu trang %d ---\n", currentPage);
            PaginationResult result = service.getpaginatedProducts(currentPage, sortCriteria);
            List<Product> products = result.products();
            totalPages = result.totalPages();

            displayProductList(products, "DANH SACH SAN PHAM: ");

            if (products.isEmpty() && result.totalItems() > 0) {
                currentPage = 1;
                continue;
            } else if (result.totalItems() == 0) {
                return;
            }

            System.out.printf("Trang: %d/%d (Tong san pham: %d)\n", 
            result.currentPage(), totalPages,result.totalItems());

            System.out.println("Cac tieu chi: [ID], [NAME], [PRICE], [DATE]");
            System.out.println("Cu phap sap xep: CRITERIA[:DIRECTION]. VD: PRICE:DESC, NAME:ASC (Mac dinh là ASC)");

            System.out.print("Nhap [T]rang sau, [P]rang truoc, [S]o trang, [C]hon sap xep hoac [Q]uay lai: ");
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
                    System.out.print("Nhap tieu chi sap xep và huong (ID/NAME/PRICE/DATE[:ASC/DESC]): ");
                    String newCriteria = scanner.nextLine().trim();
                    if (!newCriteria.isEmpty()) {
                        sortCriteria = newCriteria.toUpperCase();
                        currentPage = 1;
                        break;
                    }
                default:
                    try {
                        int newPage = Integer.parseInt(action);
                        if (newPage >= 1 && newPage <= totalPages) {
                            currentPage = newPage;
                        } else {
                            System.out.println("So trang khong hop le. Vui long nhap lai");
                        }
                    } catch (NumberFormatException e) {
                        if (!action.isEmpty()) {
                            System.out.println("Lua chon khong hop le!");
                        }
                    }
                    break;
            }
        } while (true);
    }

    private void showMenu() {
        System.out.println("\n=============================================");
        System.out.println("  QUAN LY SAN PHAM E-COMMERCE ");
        System.out.println("=============================================");
        System.out.println("1. Xem danh sach san pham (Co Phan Trang)");
        System.out.println("2. Them san pham moi (CRUD - Create)");
        System.out.println("3. Cap nhat san pham (CRUD - Update)");
        System.out.println("4. Xoa san pham (CRUD - Delete)");
        System.out.println("5. Tim kiem San pham");
        System.out.println("6. Loc San pham theo Gia (Filter)");
        System.out.println("0. Thoat");
        System.out.println("=============================================");
    }

    private void printHeader() {
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf(
    "| %-4s | %-25s | %-12s | %-40s | %-12s |\n",
    "ID", "Ten San Pham", "Gia (VND)", "Mo ta", "Ngay san xuat"
);
 
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }

    private void displayProductList(List<Product> products, String title) {
        System.out.println("\n--- " + title + " ---");
        if (products.isEmpty()) {
            System.out.println("Khong tim thay san pham nao");
            return;
        }

        printHeader();
        for (Product p : products) {
            System.out.println(p.toString());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    
    }
}
