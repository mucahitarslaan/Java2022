public class Main {

    public static void main(String[] args) {
        String student1 = "Engin";
        String student2 = "Ayse";
        String student3 = "Fatma";
        String student4 = "Beyza";

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);

        System.out.println("----------");

        String[] students = new String[3];
        students[0] = "Engin";
        students[1] = "Ayse";
        students[2] = "Fatma";


        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

        System.out.println("----------");

        for (String ogrenci : students) {
            System.out.println(ogrenci);
        }

    }
}