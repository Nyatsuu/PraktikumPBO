import java.util.ArrayList;

class DataHandler {
    private ArrayList<Kamera> dataKamera = new ArrayList<>();

    void tambahData(Kamera kamera) {
        dataKamera.add(kamera);
    }

    ArrayList<Kamera> lihatData() {
        return dataKamera;
    }

    void updateData(int index, String newMerek, int newJumlah) {
        Kamera kamera = dataKamera.get(index);
        kamera.setMerek(newMerek);
        kamera.setJumlah(newJumlah);
    }

    void hapusData(int index) {
        dataKamera.remove(index);
    }
}
