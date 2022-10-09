public class Main {
    public static void main(String[] args) {

        Product product = new Product();
        product.id = 1;
        product.name = "Mouse";
        product.price= 10;

        ProductManager productManager = new ProductManager();
        productManager.add(product);

        DatabaseHelper.crud.createConnection(); //sadece göstermek amaçlı yapılmıştır. Normalde fonksiyonları ayrı classlarda yazmamız gerekir.
    }
}