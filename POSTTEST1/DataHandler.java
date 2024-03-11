import java.util.ArrayList;

public class DataHandler {
    private ArrayList<Kamera> dataKamera = new ArrayList<>();

    public void tambahData(String merek, int jumlah) {
        dataKamera.add(new Kamera(merek, jumlah));
    }

    public ArrayList<Kamera> lihatData() {
        return dataKamera;
    }

    public void updateData(int index, String newMerek, int newJumlah) {
        Kamera kamera = dataKamera.get(index);
        kamera.setMerek(newMerek);
        kamera.setJumlah(newJumlah);
    }

    public void hapusData(int index) {
        dataKamera.remove(index);
    }
}
