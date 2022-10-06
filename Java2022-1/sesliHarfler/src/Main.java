public class Main {

    public static void main(String[] args) {

        char harf = 'a';

        switch (harf) {

            case 'A':
            case 'I':
            case 'O':
            case 'U':
            case 'a':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("Kalın Ünlü Harf");
                break;
            default:
                System.out.println("İnce Ünlü Harf");
        }
    }
}