public class Main {
    public static void main(String[] args) {
        int num1=12;
        int num2=23;
        int num3=34;

        int result= num1;

        if(result<num2){
            result=num2;
        }
        if(result<num3){
            result=num3;
        }
        System.out.println("En büyük sayı : "+result);
    }
}