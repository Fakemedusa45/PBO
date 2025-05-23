package model;

import java.util.Date;

public class Reservasi implements ReservasiInterface {
    private static int idCounter = 1;
    private final int ID_Reservasi;
    private String nama;
    private boolean status;
    private Date waktuMulai;
    private Barber barber;

    public Reservasi(String nama, Date waktuMulai) {
        this.ID_Reservasi = idCounter++;
        this.nama = nama;
        this.waktuMulai = waktuMulai;
        this.status = false;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public Barber getBarber() {
        return barber;
    }

    @Override
    // public void detailReservasi() {
    //     System.out.println("ID: " + ID_Reservasi + ", Nama: " + nama + ", Waktu: " + waktuMulai + 
    //         ", Barber: " + (barber != null ? barber.getUsername() : "Belum dipilih") + 
    //         ", Status: " + (status ? "Diterima" : "Menunggu"));
    // }
    public void detailReservasi() {
    String namaBarber = (barber != null) ? barber.getUsername() : "Belum dipilih";
    String statusReservasi = status ? "Diterima" : "Menunggu";

    // Header
    System.out.printf("| %-12s | %-15s | %-20s | %-15s | %-10s |\n",
                      "ID", "Nama", "Waktu", "Barber", "Status");
    System.out.println("--------------------------------------------------------------------------------------");

    // Isi data
    System.out.printf("| %-12s | %-15s | %-20s | %-15s | %-10s |\n",
                      ID_Reservasi, nama, waktuMulai, namaBarber, statusReservasi);
}
}
