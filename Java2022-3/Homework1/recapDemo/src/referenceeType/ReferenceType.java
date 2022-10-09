package referenceeType;

public class ReferenceType {
    public void referenceType()
    {
        System.out.println("------Reference Type------");
        int sayi1 = 10;
        int sayi2 = 20;
        sayi1=sayi2;
        sayi2=1000;
        System.out.println(sayi1);
        System.out.println(sayi2);


        int[] sayilar1 = new int[]{1,2,3};
        int[] sayilar2 = new int[]{100,200,300};

        sayilar1 = sayilar2;

        sayilar2[0]=77;

        System.out.println(sayilar1[0]);
        System.out.println("------Reference Type------");
    }
}
