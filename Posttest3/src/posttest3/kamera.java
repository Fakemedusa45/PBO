package posttest3;

class Kamera extends Produk {
    private boolean mirorless;
    private boolean tipeSensor; // true = Full-frame, false = Crop sensor

    public Kamera(int id, String merk, double harga, boolean status, boolean mirorless, boolean tipeSensor) {
        super(id, merk, harga, status);
        this.mirorless = mirorless;
        this.tipeSensor = tipeSensor;
    }

    public boolean isMirorless() {
        return mirorless;
    }

    public void setMirorless(boolean mirorless) {
        this.mirorless = mirorless;
    }

    public boolean isTipeSensor() {
        return tipeSensor;
    }

    public void setTipeSensor(boolean tipeSensor) {
        this.tipeSensor = tipeSensor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mirorless: " + mirorless + ", Tipe Sensor: " + (tipeSensor ? "Full-frame" : "Crop Sensor");
    }
}
