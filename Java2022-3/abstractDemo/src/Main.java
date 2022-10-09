public class Main {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager(new MyDatabaseManager());
        customerManager.getCustomers();
    }
}