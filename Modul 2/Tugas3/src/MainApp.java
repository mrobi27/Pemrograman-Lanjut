public class MainApp {
    public static void main(String[] args) {
        LaundryJob job = new LaundryJob(
                "Alice", "Jl. Melati No. 10", "Wash & Fold",
                50.0, 30.0, 600.0
        );

        job.detailedInfo(); // info lengkap (masih memanggil dI() yang belum di-rename)
        job.checkStatus();           // status
        job.displayRoute();           // rute
        job.displayEstimatedDuration();          // estimasi durasi
        job.slowDown(200);  // perlambat
        job.speedUp(150);   // percepat
    }
}
