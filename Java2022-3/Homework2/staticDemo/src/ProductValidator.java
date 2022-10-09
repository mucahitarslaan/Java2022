public class ProductValidator {
    static {
        System.out.println("Static constructor ran");
    }
    public static boolean isValid(Product product) {
        if (product.price > 0 && !product.name.isEmpty()) {
            return true;
        } else
            return false;
    }
}
