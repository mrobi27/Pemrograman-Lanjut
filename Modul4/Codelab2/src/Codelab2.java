import java.util.Random;
import java.util.Scanner;

public class Codelab2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Menghasilkan Bilangan Bulat Acak");
            System.out.println("2. Mengambil Karakter Acak dari String");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch(pilihan) {

                case 1:
                    System.out.print("Masukkan nilai minimum: ");
                    int min = sc.nextInt();

                    System.out.print("Masukkan nilai maksimum: ");
                    int max = sc.nextInt();

                    if (min > max) {
                        System.out.println("Error: minimum tidak boleh lebih besar dari maksimum.");
                    } else {
                        int randomNum = rand.nextInt((max - min) + 1) + min;
                        System.out.println("Bilangan bulat acak antara " + min + " dan " + max + ": " + randomNum);
                    }
                    break;

                case 2:
                    System.out.print("Masukkan sebuah kata/kalimat: ");
                    String text = sc.nextLine();

                    if (text.isEmpty()) {
                        System.out.println("String kosong, tidak dapat mengambil karakter.");
                    } else {
                        int indexRandom = rand.nextInt(text.length());
                        char karakter = text.charAt(indexRandom);
                        System.out.println("Karakter acak dari string: " + karakter);
                    }
                    break;

                case 3:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 3);

        sc.close();
    }
}
