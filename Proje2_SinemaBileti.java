/*
Mustafa haccar
250541623
26.11.2025
Sinema Bileti nasıl hesaplanır yapan program
 */
import java.util.Scanner;

public class SinemaBileti {

    // 1) Hafta sonu mu?
    public static boolean isWeekend(int gun) {
        return gun == 6 || gun == 7; // Cumartesi=6, Pazar=7
    }

    // 2) Matine mi? (12:00 öncesi)
    public static boolean isMatinee(int saat) {
        return saat < 12;
    }

    // 3) Temel fiyat hesapla
    public static int calculateBasePrice(int gun, int saat) {
        boolean weekend = isWeekend(gun);
        boolean matinee = isMatinee(saat);

        if (!weekend && matinee) return 45; // Hafta içi matine
        if (!weekend && !matinee) return 65; // Hafta içi normal
        if (weekend && matinee) return 55; // Hafta sonu matine
        return 85; // Hafta sonu normal
    }

    // 4) İndirim hesapla
    public static double calculateDiscount(int yas, int meslek, int gun) {
        // Yaşa göre indirimler
        if (yas >= 65) return 0.30; // %30
        if (yas < 12) return 0.25;  // %25

        boolean weekend = isWeekend(gun);

        // Meslek indirimleri
        switch (meslek) {
            case 1: // Öğrenci
                if (!weekend) return 0.20; // Pazartesi-Perşembe
                else return 0.15;          // Cuma-Pazar
            case 2: // Öğretmen
                if (gun == 3) return 0.35; // Çarşamba
                break;
        }

        return 0.0; // Diğer
    }

    // 5) Film türü ekstra ücreti
    public static int getFormatExtra(int filmTuru) {
        switch (filmTuru) {
            case 1: return 0;   // 2D
            case 2: return 25;  // 3D
            case 3: return 35;  // IMAX
            case 4: return 50;  // 4DX
        }
        return 0;
    }

    // 6) Final fiyat hesaplama
    public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru) {

        int basePrice = calculateBasePrice(gun, saat);
        double discountRate = calculateDiscount(yas, meslek, gun);

        double discountedPrice = basePrice - (basePrice * discountRate);
        int extra = getFormatExtra(filmTuru);

        return discountedPrice + extra;
    }

    // 7) Bilet bilgisi oluştur
    public static void generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru) {
        double finalPrice = calculateFinalPrice(gun, saat, yas, meslek, filmTuru);

        System.out.println("--------- Bilet Bilgisi ---------");
        System.out.println("Gün: " + gun);
        System.out.println("Saat: " + saat);
        System.out.println("Yaş: " + yas);
        System.out.println("Meslek: " + meslek);
        System.out.println("Film Türü: " + filmTuru);
        System.out.println("Toplam Fiyat: " + finalPrice + " TL");
        System.out.println("---------------------------------");
    }

    // MAIN
    public static void main(String[] args) {

        // Verilen örnek değerler:
        int gun = 4;       // Perşembe
        int saat = 10;     // Matine
        int yas = 22;
        int meslek = 1;    // Öğrenci
        int filmTuru = 2;  // 3D

        generateTicketInfo(gun, saat, yas, meslek, filmTuru);
    }
}
