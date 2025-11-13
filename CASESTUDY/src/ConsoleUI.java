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
            System.out.print("Select function: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.err.println("Vui lòng chỉ nhập số cho lựa chọn chức năng");
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

    private void createProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProduct'");
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
