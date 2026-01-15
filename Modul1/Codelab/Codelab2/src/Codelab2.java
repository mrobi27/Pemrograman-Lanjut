import java.util.Scanner;

class InvalidAgeException extends Exception{
    public InvalidAgeException (String message){
        super(message);
    }
}

public class Codelab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            System.out.print("Masukkan usia Anda: ");
            int usia = scan.nextInt();
            cekUsia(usia);
            System.out.println("Usia anda adalah " +usia);
        }catch(InvalidAgeException a){
            System.out.println("Kesalahan: " + a.getMessage());
        }catch(Exception e){
            System.out.println("Input tidak valid.");
        }
        finally{
            scan.close();
        }

    }

    public static void cekUsia(int usia) throws InvalidAgeException{
        if(usia <= 0 || usia >= 120){
            throw  new InvalidAgeException("Usia harus lebih besar dari 0 dan kurang dari 120");
        }
    }

}