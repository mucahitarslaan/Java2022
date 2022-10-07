package business;

import entities.Customer;

public class CustomerManager {
    private final Customer customer;
    private final ICreditManager creditManager;

    public CustomerManager(Customer customer, ICreditManager creditManager) {
        this.customer = customer;
        this.creditManager = creditManager;
    }

    public void save()
    {
        System.out.println("Müşteri kaydedildi");
    }

    public void delete()
    {
        System.out.println("Müşteri silindi");
    }

    public void giveCredit()
    {
        creditManager.calculate();
        System.out.println("Kredi verildi");
    }
}
