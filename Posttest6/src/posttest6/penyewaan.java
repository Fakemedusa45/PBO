package posttest6;

public class penyewaan implements sewa {
    private int id;
    private String tipeBarang;
    private int idBarang;
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

    // Implementasi interface
    @Override
    public void ajukanSewa() {
        System.out.println("Penyewaan dengan ID " + id + " telah diajukan.");
    }

    @Override
    public void batalkanSewa() {
        System.out.println("Penyewaan dengan ID " + id + " telah dibatalkan.");
    }
}
