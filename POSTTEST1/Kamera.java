public class Kamera {
    private String merek;
    private int jumlah;

    public Kamera(String merek, int jumlah) {
        this.merek = merek;
        this.jumlah = jumlah;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return "Merek Kamera: " + merek + ", Jumlah: " + jumlah;
    }
}
