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
        System.out.println("Pilih jenis kamera:");
        System.out.println("1. DSLR");
        System.out.println("2. Mirrorless");
        System.out.print("Pilih jenis kamera: ");
        int jenisKamera = scanner.nextInt();
        switch (jenisKamera) {
            case 1:
                tambahDataDSLR();
                break;
            case 2:
                tambahDataMirrorless();
                break;
            default:
                System.out.println("Jenis kamera tidak valid.");
        }
    }

    private void tambahDataDSLR() {
        System.out.print("Masukkan merek kamera DSLR: ");
        scanner.nextLine(); // consume newline
        String merek = scanner.nextLine();
        System.out.print("Masukkan jumlah: ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukkan lensa: ");
        scanner.nextLine(); // consume newline
        String lensa = scanner.nextLine();
        dataHandler.tambahData(new DSLR(merek, jumlah, lensa));
        System.out.println("Data kamera DSLR berhasil ditambahkan.");
    }

    private void tambahDataMirrorless() {
        System.out.print("Masukkan merek kamera Mirrorless: ");
        scanner.nextLine(); // consume newline
        String merek = scanner.nextLine();
        System.out.print("Masukkan jumlah: ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukkan sensor: ");
        scanner.nextLine(); // consume newline
        String sensor = scanner.nextLine();
        dataHandler.tambahData(new Mirrorless(merek, jumlah, sensor));
        System.out.println("Data kamera Mirrorless berhasil ditambahkan.");
    }

    private void lihatData() {
        ArrayList<Kamera> dataKamera = dataHandler.lihatData();
        if (dataKamera.isEmpty()) {
            System.out.println("Belum ada data kamera.");
        } else {
            System.out.println("Data Kamera DSLR:");
            boolean foundDSLR = false;
            for (Kamera kamera : dataKamera) {
                if (kamera instanceof DSLR) {
                    foundDSLR = true;
                    System.out.println("- " + kamera);
                }
            }
            if (!foundDSLR) {
                System.out.println("Tidak ada data kamera DSLR.");
            }
            
            System.out.println("\nData Kamera Mirrorless:");
            boolean foundMirrorless = false;
            for (Kamera kamera : dataKamera) {
                if (kamera instanceof Mirrorless) {
                    foundMirrorless = true;
                    System.out.println("- " + kamera);
                }
            }
            if (!foundMirrorless) {
                System.out.println("Tidak ada data kamera Mirrorless.");
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
