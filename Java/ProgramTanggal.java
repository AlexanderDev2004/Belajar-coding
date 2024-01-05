import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProgramTanggal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Input jumlah data
        System.out.print("Masukkan jumlah data: ");
        int jumlahData = scanner.nextInt();

        // Inisialisasi array 2D untuk menyimpan tanggal dan data
        String[][] data = new String[jumlahData][2];

        // Input tanggal dan data
        for (int i = 0; i < jumlahData; i++) {
            System.out.println("Data ke-" + (i + 1));
            
            // Input tanggal
            System.out.print("Masukkan tanggal (dd-MM-yyyy): ");
            String tanggalString = scanner.next();

            // Validasi format tanggal
            try {
                dateFormat.setLenient(false);
                Date tanggal = dateFormat.parse(tanggalString);

                // Simpan tanggal
                data[i][0] = dateFormat.format(tanggal);

                // Input data
                System.out.print("Masukkan data: ");
                data[i][1] = scanner.next();
            } catch (ParseException e) {
                System.out.println("Format tanggal tidak valid. Masukkan kembali.");
                i--; // Mengulang iterasi untuk input yang tidak valid
            }
        }

        // Cari data berdasarkan range tanggal
        System.out.println("\nCari data berdasarkan range tanggal:");
        System.out.print("Masukkan tanggal awal (dd-MM-yyyy): ");
        String tanggalAwalString = scanner.next();

        System.out.print("Masukkan tanggal akhir (dd-MM-yyyy): ");
        String tanggalAkhirString = scanner.next();

        try {
            Date tanggalAwal = dateFormat.parse(tanggalAwalString);
            Date tanggalAkhir = dateFormat.parse(tanggalAkhirString);

            // Tampilkan data yang berada dalam range tanggal
            System.out.println("\nData dalam range tanggal:");
            for (int i = 0; i < jumlahData; i++) {
                Date tanggalData = dateFormat.parse(data[i][0]);
                if (tanggalData.after(tanggalAwal) && tanggalData.before(tanggalAkhir)) {
                    System.out.println("Tanggal: " + data[i][0] + ", Data: " + data[i][1]);
                }
            }
        } catch (ParseException e) {
            System.out.println("Format tanggal tidak valid.");
        }

        scanner.close();
    }
}
