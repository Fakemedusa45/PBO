package posttest;

class kamera {
    private int idKamera;
    private String merkKamera;
    private double hargaKamera;
    private boolean statusKamera;
    private boolean mirorless;
    private boolean tipeSensor;

    public kamera(int idKamera, String merkKamera, double hargaKamera, boolean statusKamera, boolean mirorless, boolean tipeSensor) {
        this.idKamera = idKamera;
        this.merkKamera = merkKamera;
        this.hargaKamera = hargaKamera;
        this.statusKamera = statusKamera;
        this.mirorless = mirorless;
        this.tipeSensor = tipeSensor;
    }

    public int getIdKamera() {
        return idKamera;
    }

    public String getMerkKamera() {
        return merkKamera;
    }

    public void setMerkKamera(String merkKamera) {
        this.merkKamera = merkKamera;
    }

    public double getHargaKamera() {
        return hargaKamera;
    }

    public void setHargaKamera(double hargaKamera) {
        this.hargaKamera = hargaKamera;
    }

    public boolean isStatusKamera() {
        return statusKamera;
    }

    public void setStatusKamera(boolean statusKamera) {
        this.statusKamera = statusKamera;
    }

    @Override
    public String toString() {
        return "ID: " + idKamera + ", Merk: " + merkKamera + ", Harga: " + hargaKamera + ", Status: " + (statusKamera ? "Tersedia" : "Tidak Tersedia") + ", Mirorless: " + mirorless + ", Tipe Sensor: " + tipeSensor;
    }
}
