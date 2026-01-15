import java.util.Arrays;

public class Order {
    private final MenuItem[] menu;
    private final int[] jumlahPesanan; // index sejajar dengan menu

    public Order(MenuItem[] menu) {
        this.menu = menu;
        this.jumlahPesanan = new int[menu.length];
    }

    public void addById(int id, int jumlah) {
        if (id < 1 || id > menu.length || jumlah <= 0) return;
        jumlahPesanan[id - 1] += jumlah;
    }

    public int[] getJumlahPesanan() {
        return Arrays.copyOf(jumlahPesanan, jumlahPesanan.length);
    }
    public MenuItem[] getMenu() { return menu; }

    public int subtotal() {
        int s = 0;
        for (int i = 0; i < menu.length; i++) s += menu[i].getPrice() * jumlahPesanan[i];
        return s;
    }
}
