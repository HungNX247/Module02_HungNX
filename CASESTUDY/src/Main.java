public class Main {
    public static void main(String[] args) {
        IProductRepository repository = ProductFactory.creatProductRepository("file");

        ProductService service = new ProductService(repository);

        ConsoleUI ui = new ConsoleUI(service);
        ui.run();
    }
}
