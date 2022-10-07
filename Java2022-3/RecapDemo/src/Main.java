import business.CustomerManager;
import business.TeacherCreditManager;
import entities.Customer;
import referenceeType.ReferenceType;

public class Main {
    public static void main(String[] args) {
        ReferenceType referenceType = new ReferenceType();
        referenceType.referenceType();

        System.out.println("---------------");
        CustomerManager customerManager = new CustomerManager(new Customer(),new TeacherCreditManager());
        customerManager.giveCredit();
    }
}