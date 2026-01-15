public class Film {
    private String judul;
    private int tahun;

    public Film(String judul, int tahun) {
        this.judul = judul;
        this.tahun = tahun;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahun() {
        return tahun;
    }

    @Override
    public String toString() {
        return "Judul: " + judul + ", Tahun: " + tahun;
    }
}
