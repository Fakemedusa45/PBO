package posttest1;

class aksesoris {
    int idAksesoris;
    String merkAksesoris;
    double hargaAksesoris;
    boolean statusAksesoris;

    public aksesoris(int idAksesoris, String merkAksesoris, double hargaAksesoris, boolean statusAksesoris) {
        this.idAksesoris = idAksesoris;
        this.merkAksesoris = merkAksesoris;
        this.hargaAksesoris = hargaAksesoris;
        this.statusAksesoris = statusAksesoris;
    }

    @Override
    public String toString() {
        return "ID: " + idAksesoris + ", Merk: " + merkAksesoris + ", Harga: " + hargaAksesoris + ", Status: " + (statusAksesoris ? "Tersedia" : "Tidak Tersedia");
    }
}