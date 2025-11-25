/*
 Mustafa haccar
250541623
25.11.2025
Öğrenci Not Ortalaması Hesaplama
*/
import java.util.Scanner;
public class OrtalamaNot {
    public static double calculateAverage(int vize, int finalNotu, int odev) {
        double ortalama = vize * 0.3 + finalNotu * 0.4 + odev * 0.3;
        return ortalama;
    }

    public static boolean isLegal(int dogrulama) {
        if (dogrulama >= 0 && dogrulama <= 100) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPassingGrade(double ortalama) {
        if (ortalama >= 50) {
            return true ;
        } else {
            return false;
        }
    }

    public static String getLetterGrade(double ortalama) {
        String harfNotu;
        if (ortalama >= 90) {
            harfNotu = "A";

        } else if (ortalama >= 80) {
            harfNotu = "B";

        } else if (ortalama >= 70) {
            harfNotu = "C";

        } else if (ortalama >= 60) {
            harfNotu = "D";
        } else {
            harfNotu = "F";
        }

        return harfNotu;
    }


    public static boolean isHonorList(double ortalama, int vize, int finalNotu, int odev) {
        if (ortalama >= 85 && vize > 70 && finalNotu > 70 && odev > 70) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean hasRetakeRigh(double ortalama){
        if(ortalama<50 && ortalama>=40){
            return true;
        }else {
            return false;
        }
    }
    public static void main (String[]args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Vize Notu Giriniz :");
        int vizeNotu = scan.nextInt();
        if(isLegal(vizeNotu)==false){
            System.out.println("Gecersiz Sayi");
        }
        System.out.print("Final Notu Giriniz :");
        int finalNotu = scan.nextInt();
        if(isLegal(finalNotu)==false){
            System.out.println("Gecersiz Sayi");
        }
        System.out.print("Ödev Notu Giriniz :");
        int odevNotu = scan.nextInt();
        if(isLegal(odevNotu)==false){
            System.out.println("Gecersiz Sayi");
        }
        double ortalama = calculateAverage(vizeNotu, finalNotu, odevNotu);
        System.out.println("====================");
        System.out.println("ÖGRENCI RAPORU");
        System.out.println("==================");

        System.out.printf("Ortalama :%.2f\n" ,ortalama);

        if(isPassingGrade(ortalama)==true){
            System.out.println("Durum :Gecti");
        }else{
            System.out.println("Durum :Kaldi");
        }
        System.out.println("Harf Notu :" + getLetterGrade(ortalama));

        System.out.println("Onur Belgesi :" +(isHonorList(ortalama,vizeNotu,finalNotu,odevNotu)==true? "EVET" : "HAYIR"));
        System.out.println("Bütünleme :" +(hasRetakeRigh(ortalama)==true? "EVET" : "HAYIR" ));



    }
}
