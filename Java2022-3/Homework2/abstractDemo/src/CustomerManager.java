public class CustomerManager {
    private  final BaseDatabaseManager databaseManager;

    public CustomerManager(BaseDatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void getCustomers()
    {
        databaseManager.getDate();
    }
}
