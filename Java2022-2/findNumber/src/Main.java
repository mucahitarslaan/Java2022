import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        findNumber();
    }

    public static void findNumber()
    {
        int[] numbers = new int[]{1,2,3,5,6,7};
        System.out.print("Enter your number :");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        boolean haveNumber = false;

        for (int i : numbers)
        {
            if (i == number)
                haveNumber = true;
            if (haveNumber==true)
            {break;}
        }

        if (haveNumber) {
            giveMessage("The number is in the array : " + number);
        }else {
            giveMessage("The number is not in the array :" + number);
        }
    }

    public static void giveMessage(String msg)
    {
        System.out.println(msg);
    }
}