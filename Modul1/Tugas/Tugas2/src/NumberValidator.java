import java.util.Scanner;

public class NumberValidator {
    public static void main(String[] args) throws InvalidNumberException {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Masukkan sebuah angka positif: ");
            int angka = scan.nextInt();

            if (angka < 0){
                throw new InvalidNumberException("Angka harus positif!! Anda memasukkan: " + angka);
            }

            System.out.println("Angka Positif: " + angka);
        } catch (InvalidNumberException e){
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error, input harus berupa angka");
        }finally {
            scan.close();
        }
    }
}