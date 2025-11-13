import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private static final Scanner scanner = new Scanner(System.in);
    private final ProductService service;

    public ConsoleUI(ProductService service) {
        this.service = service;
    }

    public void run() {
        int choice;
        do {
            showMenu();
            System.out.print("Lua chon chuc nang: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.err.println("Vui long chi nhap so cho lua chon chuc nang");
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
                    case 0:
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

    private void updateProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    private void deleteProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    private void searchProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchProduct'");
    }

    private void createProduct() throws Exception {
        System.out.println("\n--- THEM SAN PHAM MOI ---");
        System.out.print("Ten san pham: ");
        String name = scanner.nextLine();

        double price = 0.0;
        boolean priceValid = false;

        while (!priceValid) {
            System.out.print("Gia (VND): ");
            try {
                price = scanner.nextDouble();
                scanner.nextLine();
                priceValid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Loi: Gia phai la so hop le.");
                scanner.nextLine();
            }
        }
    }

    private void showProduct() throws Exception {
        int currentPage = 1;
        int totalPages;

        do {
            System.out.printf("\n--- Loading %d ---\n", currentPage);
            PaginationResult result = service.getpaginatedProducts(currentPage);
            List<Product> products = result.products();
            totalPages = result.totalPages();

            displayProductList(products, "Danh sach san pham: ");

            if (products.isEmpty() && result.totalItems() > 0) {
                currentPage = 1;
                continue;
            } else if (result.totalItems() == 0) {
                return;
            }

            System.out.printf("Trang: %d/%d (Tong san pham: %d)\n", result.currentPage(), totalPages,
                    result.totalItems());
            System.out.print("Nhap [T]rang sau, [P]rang truoc, [S]o trang hoac [Q]uay lai");
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
        System.out.println("0. Thoat");
        System.out.println("=============================================");
    }

    private void displayProductList(List<Product> products, String title) {
        System.out.println("\n--- " + title + " ---");
        if (products.isEmpty()) {
            System.out.println("Khong tim thay san pham nao");
            return;
        }

        System.out.println(
                "+------+---------------------------+-----------------+------------------------------------------+");
        System.out.println(
                "| ID   | Ten San Pham              | Gia (VND)       | Mo Ta                                    |");
        System.out.println(
                "+------+---------------------------+-----------------+------------------------------------------+");

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
