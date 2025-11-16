public class ProductFactory {
    public static IProductRepository creatProductRepository(String type) {
        if ("file".equalsIgnoreCase(type)) {
            return ProductRepository.getInstance();
        } else {
            return ProductRepository.getInstance();
        }
    }
}
