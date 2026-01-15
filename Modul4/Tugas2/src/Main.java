import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah uang: ");
        double jumlah = sc.nextDouble();
        sc.nextLine();

        System.out.print("Masukkan tanggal (dd-MM-yyyy): ");
        String inputTanggal = sc.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date tanggal = sdf.parse(inputTanggal);

        Locale[] locales = {
                new Locale("id", "ID"),
                Locale.JAPAN,
                Locale.CHINA
        };

        System.out.println();

        for (Locale loc : locales) {

            System.out.println("=== Locale: " + loc.toString() + " ===");

            String country = loc.getDisplayCountry(loc);
            Currency curr = Currency.getInstance(loc);

            System.out.println("Country         : " + country);
            System.out.println("Currency Code   : " + curr.getCurrencyCode());
            System.out.println("Currency Symbol : " + curr.getSymbol(loc));

            NumberFormat nf = NumberFormat.getCurrencyInstance(loc);
            String uangFormatted = nf.format(jumlah);
            System.out.println("Formatted Money : " + uangFormatted);

            DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, loc);
            String tanggalFormatted = df.format(tanggal);
            System.out.println("Formatted Date  : " + tanggalFormatted);

            System.out.println();
        }
    }
}
