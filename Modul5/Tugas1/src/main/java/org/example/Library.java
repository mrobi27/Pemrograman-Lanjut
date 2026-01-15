package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private static final String FILE_NAME = "books.json";
    private List<Book> books;

    public Library() {
        books = loadBooks();
    }

    // ---------------- Load JSON ----------------
    private List<Book> loadBooks() {
        try {
            FileReader reader = new FileReader(FILE_NAME);
            return new Gson().fromJson(reader, new TypeToken<List<Book>>(){}.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // ---------------- Save JSON ----------------
    private void saveBooks() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            new Gson().toJson(books, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------- CRUD ----------------
    public void addBook(String title, String author, int year) {
        books.add(new Book(title, author, year));
        saveBooks();
        System.out.println("Buku berhasil ditambahkan.\n");
    }

    public void showBooks() {
        System.out.println("\nDaftar Buku:");
        if (books.isEmpty()) {
            System.out.println("Tidak ada buku.\n");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println((i + 1) + ". " + b.getTitle() + " oleh " + b.getAuthor() + " (" + b.getYear() + ")");
        }
        System.out.println();
    }

    public void updateBook(int index, String newTitle, String newAuthor, Integer newYear) {
        Book b = books.get(index);

        if (!newTitle.isEmpty()) b.setTitle(newTitle);
        if (!newAuthor.isEmpty()) b.setAuthor(newAuthor);
        if (newYear != null) b.setYear(newYear);

        saveBooks();
        System.out.println("Buku berhasil diupdate.\n");
    }

    public void deleteBook(int index) {
        books.remove(index);
        saveBooks();
        System.out.println("Buku berhasil dihapus.\n");
    }

    public int getSize() {
        return books.size();
    }

    public Book getBook(int index) {
        return books.get(index);
    }
}
