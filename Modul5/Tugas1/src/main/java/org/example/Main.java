package org.example;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--- Menu Perpustakaan ---");
            System.out.println("1. Menambahkan Buku");
            System.out.println("2. Menampilkan Buku");
            System.out.println("3. Mengupdate Buku");
            System.out.println("4. Menghapus Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1/2/3/4/5): ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\nMenambahkan Buku Baru");
                    System.out.print("Masukkan judul buku: ");
                    String title = sc.nextLine();

                    System.out.print("Masukkan pengarang buku: ");
                    String author = sc.nextLine();

                    System.out.print("Masukkan tahun terbit buku: ");
                    int year = Integer.parseInt(sc.nextLine());

                    lib.addBook(title, author, year);
                    break;

                case "2":
                    lib.showBooks();
                    break;

                case "3":
                    lib.showBooks();
                    if (lib.getSize() == 0) break;

                    System.out.print("Masukkan nomor buku yang ingin diupdate: ");
                    int idx = Integer.parseInt(sc.nextLine()) - 1;

                    Book book = lib.getBook(idx);

                    System.out.println("\nKosongkan jika tidak ingin mengubah.");
                    System.out.print("Judul baru (" + book.getTitle() + "): ");
                    String newTitle = sc.nextLine();

                    System.out.print("Pengarang baru (" + book.getAuthor() + "): ");
                    String newAuthor = sc.nextLine();

                    System.out.print("Tahun terbit baru (" + book.getYear() + "): ");
                    String textYear = sc.nextLine();
                    Integer newYear = textYear.isEmpty() ? null : Integer.parseInt(textYear);

                    lib.updateBook(idx, newTitle, newAuthor, newYear);
                    break;

                case "4":
                    lib.showBooks();
                    if (lib.getSize() == 0) break;

                    System.out.print("Masukkan nomor buku yang ingin dihapus: ");
                    int del = Integer.parseInt(sc.nextLine()) - 1;

                    lib.deleteBook(del);
                    break;

                case "5":
                    System.out.println("Keluar dari program.");
                    sc.close();
                    return;

                default:
                    System.out.println("Menu tidak valid!\n");
            }
        }
    }
}
