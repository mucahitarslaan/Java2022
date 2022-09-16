public class Main {
    public static void main(String[] args) {

        int number = 353;
        boolean isPrime = true;

        if (number == 1){
            System.out.println("Sayı asal değildir");
            return;
        }

        if (number < 1){
            System.out.println("Sayı geçersiz");
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                isPrime = false;
            }
        }

        if (isPrime) {
            System.out.println("Asal sayı");
        } else {
            System.out.println("Asal sayı değildir");
        }
    }
}