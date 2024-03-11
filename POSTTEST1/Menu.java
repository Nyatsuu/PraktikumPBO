import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private DataHandler dataHandler = new DataHandler();

    public void tampilkanMenu() {
        while (true) {
            System.out.println("\n=== Sistem Pendataan Kamera Agus Production House ===");
            System.out.println("1. Tambah Data Kamera");
            System.out.println("2. Lihat Data Kamera");
            System.out.println("3. Update Data Kamera");
            System.out.println("4. Hapus Data Kamera");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program.");
                    System.exit(0);
                default:
                    System.out.println("Menu tidak valid.");
            }
        }
    }

    private void tambahData() {
        System.out.print("Masukkan merek kamera: ");
        scanner.nextLine(); // consume newline
        String merek = scanner.nextLine();
        System.out.print("Masukkan jumlah: ");
        int jumlah = scanner.nextInt();
        dataHandler.tambahData(merek, jumlah);
        System.out.println("Data kamera berhasil ditambahkan.");
    }

    private void lihatData() {
        ArrayList<Kamera> dataKamera = dataHandler.lihatData();
        if (dataKamera.isEmpty()) {
            System.out.println("Belum ada data kamera.");
        } else {
            System.out.println("Data Kamera:");
            for (int i = 0; i < dataKamera.size(); i++) {
                System.out.println((i + 1) + ". " + dataKamera.get(i));
            }
        }
    }

    private void updateData() {
        ArrayList<Kamera> dataKamera = dataHandler.lihatData();
        if (dataKamera.isEmpty()) {
            System.out.println("Belum ada data kamera.");
        } else {
            System.out.print("Masukkan nomor data kamera yang akan diupdate: ");
            int nomorUpdate = scanner.nextInt();
            if (nomorUpdate >= 1 && nomorUpdate <= dataKamera.size()) {
                System.out.print("Masukkan merek kamera baru: ");
                scanner.nextLine(); // consume newline
                String newMerek = scanner.nextLine();
                System.out.print("Masukkan jumlah baru: ");
                int newJumlah = scanner.nextInt();
                dataHandler.updateData(nomorUpdate - 1, newMerek, newJumlah);
                System.out.println("Data kamera berhasil diupdate.");
            } else {
                System.out.println("Nomor tidak valid.");
            }
        }
    }

    private void hapusData() {
        ArrayList<Kamera> dataKamera = dataHandler.lihatData();
        if (dataKamera.isEmpty()) {
            System.out.println("Belum ada data kamera.");
        } else {
            System.out.print("Masukkan nomor data kamera yang akan dihapus: ");
            int nomorDelete = scanner.nextInt();
            if (nomorDelete >= 1 && nomorDelete <= dataKamera.size()) {
                dataHandler.hapusData(nomorDelete - 1);
                System.out.println("Data kamera berhasil dihapus.");
            } else {
                System.out.println("Nomor tidak valid.");
            }
        }
    }
}
