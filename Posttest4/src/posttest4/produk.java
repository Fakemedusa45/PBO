package posttest4;

class Produk {
    protected int id;
    protected String merk;
    protected double harga;
    protected boolean status;

    public Produk(int id, String merk, double harga, boolean status) {
        this.id = id;
        this.merk = merk;
        this.harga = harga;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Merk: " + merk + ", Harga: " + harga + ", Status: " + (status ? "Tersedia" : "Tidak Tersedia");
    }
}
