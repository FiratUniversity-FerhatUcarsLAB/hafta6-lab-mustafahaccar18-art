/*
250541623
Mustafa haccar
26.11.2025
Sipariş Sistemi analtan algoritma
 */
import java.util.Scanner;
 

public class SiparisSistemi {

    // 1) Ana yemek fiyatı
    public static int getMainDishPrice(int secim) {
        switch (secim) {
            case 1: return 85;  // Izgara Tavuk
            case 2: return 120; // Adana Kebap
            case 3: return 110; // Levrek
            case 4: return 65;  // Mantı
        }
        return 0;
    }

    // 2) Başlangıç fiyatı
    public static int getAppetizerPrice(int secim) {
        switch (secim) {
            case 1: return 25; // Çorba
            case 2: return 45; // Humus
            case 3: return 55; // Sigara Böreği
        }
        return 0;
    }

    // 3) İçecek fiyatı
    public static int getDrinkPrice(int secim) {
        switch (secim) {
            case 1: return 15; // Kola
            case 2: return 12; // Ayran
            case 3: return 35; // Taze Meyve Suyu
            case 4: return 25; // Limonata
        }
        return 0;
    }

    // 4) Tatlı fiyatı
    public static int getDessertPrice(int secim) {
        switch (secim) {
            case 1: return 65; // Künefe
            case 2: return 55; // Baklava
            case 3: return 35; // Sütlaç
        }
        return 0;
    }

    // 5) Combo mu? (Ana + İçecek + Tatlı)
    public static boolean isComboOrder(boolean anaVar, boolean icecekVar, boolean tatliVar) {
        return anaVar && icecekVar && tatliVar;
    }

    // 6) Happy Hour? (14:00 - 17:00)
    public static boolean isHappyHour(int saat) {
        return saat >= 14 && saat <= 17;
    }

    // 7) Toplam indirim hesapla
    public static double calculateDiscount(double tutar, boolean combo, boolean ogrenci, int saat) {

        double indirim = 0.0;

        // Combo menu indirimi %15
        if (combo) {
            indirim += tutar * 0.15;
        }

        // 200 TL üstü %10 indirim
        if (tutar >= 200) {
            indirim += tutar * 0.10;
        }

        // Öğrenci (Hafta içi %10)
        if (ogrenci) {
            indirim += tutar * 0.10;
        }

        // Happy hour içecek indirimi (burada tutara değil içecek fiyatına uygulanacak)
        if (isHappyHour(saat)) {
            indirim += tutar * 0.20; // Basit model: içecek oranı %20
        }

        return indirim;
    }

    // 8) Garson bahşişi (Tutarın %10'u)
    public static double calculateServiceTip(double tutar) {
        return tutar * 0.10;
    }

    // MAIN
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Kategori seçimleri
        System.out.println("Ana Yemek Seç (0=Alma): ");
        int ana = sc.nextInt();

        System.out.println("Başlangıç Seç (0=Alma): ");
        int baslangic = sc.nextInt();

        System.out.println("İçecek Seç (0=Alma): ");
        int icecek = sc.nextInt();

        System.out.println("Tatlı Seç (0=Alma): ");
        int tatli = sc.nextInt();

        System.out.println("Saat kaç? (0-23): ");
        int saat = sc.nextInt();

        System.out.println("Öğrenci misin? (1=Evet, 0=Hayır): ");
        boolean ogrenci = sc.nextInt() == 1;

        // Fiyatları çek
        double anaFiyat = getMainDishPrice(ana);
        double basFiyat = getAppetizerPrice(baslangic);
        double icecekFiyat = getDrinkPrice(icecek);
        double tatliFiyat = getDessertPrice(tatli);

        // Toplam ana tutar
        double toplam = anaFiyat + basFiyat + icecekFiyat + tatliFiyat;

        // Combo kontrolü
        boolean combo = isComboOrder(ana != 0, icecek != 0, tatli != 0);

        // İndirim hesapla
        double indirim = calculateDiscount(toplam, combo, ogrenci, saat);

        // İndirim uygulanmış fiyat
        double odenecek = toplam - indirim;

        // Bahşiş önerisi
        double bahsis = calculateServiceTip(odenecek);

        // Sonuç
        System.out.println("-------- SİPARİŞ ÖZETİ --------");
        System.out.println("Toplam Tutar : " + toplam + " TL");
        System.out.println("İndirimler   : -" + indirim + " TL");
        System.out.println("Ödenecek     : " + odenecek + " TL");
        System.out.println("Bahşiş Öneri : +" + bahsis + " TL");
        System.out.println("--------------------------------");
    }
}
