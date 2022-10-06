public class Main {
    public static void main(String[] args) {

        System.out.println(addition(3,5));
        System.out.println(addition(1,2,3,5,6,7,8));
    }

    public static int addition(int number1, int number2)
    {
        return number1 + number2;
    }

    private static int addition(int... numbers)
    {
        int sum = 0;
        for (int number : numbers)
        {
            sum += number;
        }
        return sum;
    }

}