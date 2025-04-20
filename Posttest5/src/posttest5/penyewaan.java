package posttest5;

final class penyewaan { // final class
    private final int id;
    private String tipeBarang;
    private final int idBarang;
    private boolean disetujui;

    public penyewaan(int id, String tipeBarang, int idBarang) {
        this.id = id;
        this.tipeBarang = tipeBarang;
        this.idBarang = idBarang;
        this.disetujui = false;
    }

    public int getId() {
        return id;
    }

    public String getTipeBarang() {
        return tipeBarang;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public boolean isDisetujui() {
        return disetujui;
    }

    public void setDisetujui(boolean disetujui) {
        this.disetujui = disetujui;
    }

    @Override
    public String toString() {
        return "ID Sewa: " + id + ", Tipe: " + tipeBarang + ", ID Barang: " + idBarang + ", Status: " + (disetujui ? "Disetujui" : "Menunggu Persetujuan");
    }
}
