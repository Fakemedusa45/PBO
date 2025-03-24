package posttest;

class aksesoris {
    private int idAksesoris;
    private String merkAksesoris;
    private double hargaAksesoris;
    private boolean statusAksesoris;

    public aksesoris(int idAksesoris, String merkAksesoris, double hargaAksesoris, boolean statusAksesoris) {
        this.idAksesoris = idAksesoris;
        this.merkAksesoris = merkAksesoris;
        this.hargaAksesoris = hargaAksesoris;
        this.statusAksesoris = statusAksesoris;
    }

    public int getIdAksesoris() {
        return idAksesoris;
    }

    public String getMerkAksesoris() {
        return merkAksesoris;
    }

    public void setMerkAksesoris(String merkAksesoris) {
        this.merkAksesoris = merkAksesoris;
    }

    public double getHargaAksesoris() {
        return hargaAksesoris;
    }

    public void setHargaAksesoris(double hargaAksesoris) {
        this.hargaAksesoris = hargaAksesoris;
    }

    public boolean isStatusAksesoris() {
        return statusAksesoris;
    }

    public void setStatusAksesoris(boolean statusAksesoris) {
        this.statusAksesoris = statusAksesoris;
    }

    @Override
    public String toString() {
        return "ID: " + idAksesoris + ", Merk: " + merkAksesoris + ", Harga: " + hargaAksesoris + ", Status: " + (statusAksesoris ? "Tersedia" : "Tidak Tersedia");
    }
}