/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posttest1;

/**
 *
 * @author DELL
 */

class kamera {
    int idKamera;
    String merkKamera;
    double hargaKamera;
    boolean statusKamera;
    boolean mirorless;
    boolean tipeSensor;

    public kamera(int idKamera, String merkKamera, double hargaKamera, boolean statusKamera, boolean mirorless, boolean tipeSensor) {
        this.idKamera = idKamera;
        this.merkKamera = merkKamera;
        this.hargaKamera = hargaKamera;
        this.statusKamera = statusKamera;
        this.mirorless = mirorless;
        this.tipeSensor = tipeSensor;
    }

    @Override
    public String toString() {
        return "ID: " + idKamera + ", Merk: " + merkKamera + ", Harga: " + hargaKamera + ", Status: " + (statusKamera ? "Tersedia" : "Tidak Tersedia") + ", Mirorless: " + mirorless + ", Tipe Sensor: " + tipeSensor;
    }
}
