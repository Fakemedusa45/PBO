package model;

public class Paket {
    private static int idCounter = 1;
    private final int ID_Paket;
    private String nama;
    private String deskripsi;
    private double harga;

    public Paket(String nama, String deskripsi, double harga) {
        this.ID_Paket = idCounter++;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
    }

    public int getIDPaket() {
        return ID_Paket;
    }

    public String getNama() {
        return nama;
    }

    public String getDesk() {
        return deskripsi;
    }

    public double getHarga() {
        return harga;
    }

    public void getPaket() {
        System.out.println("ID Paket: " + ID_Paket);
        System.out.println("Nama Paket: " + nama);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Harga: " + harga);
    }
}