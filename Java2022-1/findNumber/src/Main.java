public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[] {1,3,4,6,7,8};
        int given = 6;
        boolean find = false;
        for (int number : numbers) {
            if(number==given) {
                find = true;
                break;
            }
        }

        if(find)
        {
            System.out.println("Sayı mevcuttur");
        }else {
            System.out.println("Sayı mevcut değildir");
        }
    }
}