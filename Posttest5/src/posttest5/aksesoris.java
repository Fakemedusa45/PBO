package posttest5;

class aksesoris extends Produk {
    public aksesoris(int id, String merk, double harga, boolean status) {
        super(id, merk, harga, status);
    }
    
    public String getDeskripsiBarang() {
        return "Aksesoris " + merk;
    }
}