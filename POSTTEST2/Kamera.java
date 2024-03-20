class Kamera {
    private String merek;
    private int jumlah;

    Kamera(String merek, int jumlah) {
        this.merek = merek;
        this.jumlah = jumlah;
    }

    String getMerek() {
        return merek;
    }

    void setMerek(String merek) {
        this.merek = merek;
    }

    int getJumlah() {
        return jumlah;
    }

    void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return "Merek Kamera: " + merek + ", Jumlah: " + jumlah;
    }
}
