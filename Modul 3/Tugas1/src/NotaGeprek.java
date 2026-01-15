import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class NotaGeprek {
    public static void main(String[] args) {
        MenuItem[] menu = {
                new MenuItem(1, "Ayam Geprek Lv.1", 10000),
                new MenuItem(2, "Ayam Geprek Lv.2", 11000),
                new MenuItem(3, "Ayam Geprek Lv.3", 12000),
                new MenuItem(4, "Ayam Geprek Lv.4", 13000),
                new MenuItem(5, "Ayam Geprek Lv.5", 15000)
        };
        Order order = new Order(menu);

        NumberFormat rp = NumberFormat.getCurrencyInstance(new Locale("id","ID"));
        Scanner sc = new Scanner(System.in);

        System.out.println("=== RESTORAN XYZ – AYAM GEPREK ===");
        System.out.println("ID  Nama                  Harga");
        System.out.println("--------------------------------------");
        for (MenuItem m : menu) {
            System.out.printf("%-3d %-20s %10s%n", m.getId(), m.getName(), rp.format(m.getPrice()));
        }
        System.out.println("--------------------------------------");

        while (true) {
            System.out.print("Masukkan ID menu (0 untuk selesai): ");
            int id = safeInt(sc);
            if (id == 0) break;

            System.out.print("Jumlah pesanan: ");
            int j = safeInt(sc);

            order.addById(id, j);
            if (id >= 1 && id <= menu.length && j > 0) {
                System.out.println("Ditambahkan: " + menu[id - 1].getName() + " x" + j);
            } else {
                System.out.println("Input tidak valid.");
            }
        }

        // === BLOK PERHITUNGAN (ketik: calcnota → Tab) ===
        int subtotal = order.subtotal();
        int ppn = (int) Math.round(subtotal * 0.11);
        int service = (int) Math.round(subtotal * 0.05);
        int total = subtotal + ppn + service;

        System.out.println("\n=========== NOTA PEMESANAN ===========");
        int[] jumlah = order.getJumlahPesanan();
        for (int i = 0; i < menu.length; i++) {
            if (jumlah[i] > 0) {
                int line = menu[i].getPrice() * jumlah[i];
                System.out.printf("%-22s x%-3d = %10s%n", menu[i].getName(), jumlah[i], rp.format(line));
            }
        }
        System.out.println("--------------------------------------");
        System.out.printf("%-18s : %10s%n", "Subtotal", rp.format(subtotal));
        System.out.printf("%-18s : %10s%n", "PPN 11%", rp.format(ppn));
        System.out.printf("%-18s : %10s%n", "Service 5%", rp.format(service));
        System.out.printf("%-18s : %10s%n", "TOTAL BAYAR", rp.format(total));
        System.out.println("======================================");
    }

    private static int safeInt(Scanner sc) {
        while (true) {
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (Exception e) { System.out.print("Harus angka, ulangi: "); }
        }
    }
}
