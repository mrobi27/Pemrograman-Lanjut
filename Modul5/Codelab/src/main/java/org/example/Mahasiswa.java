package org.example;

public class Mahasiswa {
    private String nama;
    private int semester;
    private String matkul;

    public Mahasiswa(String nama, int semester, String matkul) {
        this.nama = nama;
        this.semester = semester;
        this.matkul = matkul;
    }

    public String getNama() {
        return nama;
    }

    public int getSemester() {
        return semester;
    }

    public String getMatkul() {
        return matkul;
    }
}
