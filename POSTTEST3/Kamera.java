class Kamera {
    protected String merek;
    protected int jumlah;

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

class DSLR extends Kamera {
    private String lensa;

    public DSLR(String merek, int jumlah, String lensa) {
        super(merek, jumlah);
        this.lensa = lensa;
    }

    public String getLensa() {
        return lensa;
    }

    public void setLensa(String lensa) {
        this.lensa = lensa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Jenis: DSLR, Lensa: " + lensa;
    }
}

class Mirrorless extends Kamera {
    private String sensor;

    public Mirrorless(String merek, int jumlah, String sensor) {
        super(merek, jumlah);
        this.sensor = sensor;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Jenis: Mirrorless, Sensor: " + sensor;
    }
}
