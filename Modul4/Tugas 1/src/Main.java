import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Film> daftarFilm = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Menu Manajemen Film ===");
            System.out.println("1. Tambah Film Baru");
            System.out.println("2. Urutkan Berdasarkan Nama Film (A-Z)");
            System.out.println("3. Urutkan Berdasarkan Tahun (Ascending)");
            System.out.println("4. Keluar Program");
            System.out.print("Masukkan pilihan (1-4): ");
            int pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {

                case 1:
                    System.out.print("Masukkan judul film: ");
                    String judul = sc.nextLine();

                    System.out.print("Masukkan tahun rilis: ");
                    int tahun = sc.nextInt();

                    daftarFilm.add(new Film(judul, tahun));
                    System.out.println("Film berhasil ditambahkan!");
                    break;

                case 2:
                    Collections.sort(daftarFilm, Comparator.comparing(Film::getJudul));
                    System.out.println("\n=== Daftar Film (Urut Nama A-Z) ===");
                    for (Film f : daftarFilm) {
                        System.out.println(f);
                    }
                    break;

                case 3:
                    Collections.sort(daftarFilm, Comparator.comparingInt(Film::getTahun));
                    System.out.println("\n=== Daftar Film (Urut Tahun Ascending) ===");
                    for (Film f : daftarFilm) {
                        System.out.println(f);
                    }
                    break;

                case 4:
                    System.out.println("Keluar dari program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
