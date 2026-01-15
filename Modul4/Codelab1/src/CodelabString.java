import java.util.Scanner;

public class CodelabString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan sebuah kalimat: ");
        String kalimat = sc.nextLine();

        String[] kata = kalimat.split(" ");
        String kataKedua = (kata.length >= 2) ? kata[1] : "Tidak ada kata kedua";
        System.out.println("Kata kedua : " + kataKedua);

        String kapital = kalimat.toUpperCase();
        System.out.println("Huruf Kapital : " + kapital);

        boolean adaJava = kalimat.toLowerCase().contains("java");
        System.out.println("Apakah mengandung kata 'java'? : " + adaJava);

        System.out.print("Masukkan kata/kalimat untuk ditambah di akhir: ");
        String tambahan = sc.nextLine();

        StringBuilder sb = new StringBuilder(kalimat);
        sb.append(" ").append(tambahan);

        System.out.println("Setelah menambah kata/kalimat : " + sb);

        StringBuilder dibalik = new StringBuilder(sb);
        dibalik.reverse();
        System.out.println("Kalimat terbalik: " + dibalik);

        sc.close();
    }
}
