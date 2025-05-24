package model;

import java.util.ArrayList;

public class ManajemenReservasi implements ManajemenReservasiInterface {
    private ArrayList<Reservasi> reservasiList;

    public ManajemenReservasi() {
        this.reservasiList = new ArrayList<>();
    }

    public int getJumlahReservasi() {
        return reservasiList.size();
    }

    public void tambahReservasi(Reservasi reservasi) {
        reservasiList.add(reservasi);
    }

    public void getAllReservasi() {
        if (reservasiList.isEmpty()) {
            System.out.println("Tidak ada reservasi yang tersedia.");
        } else {
            System.out.println("Daftar Reservasi:");
            for (Reservasi r : reservasiList) {
                System.out.println("ID Reservasi: " + r.getIDReservasi() + ", Waktu Mulai: " + r.getWaktuMulai());
            }
        }
    }

    public void getReservasiByBarber(Barber barber) {
        System.out.println("Reservasi untuk Barber " + barber.getUsername() + ":");
        for (Reservasi r : reservasiList) {
            if (r.getBarber().equals(barber) && !r.isStatus()) {
                System.out.println("ID Reservasi: " + r.getIDReservasi() + ", Waktu Mulai: " + r.getWaktuMulai() + r.getPaket().getNama());
            }
        }
    }

    public void getReservasiByPelanggan(Pelanggan pelanggan) {
        System.out.println("Reservasi untuk Pelanggan " + pelanggan.getUsername() + ":");
        for (Reservasi r : reservasiList) {
            if (r.getPelanggan().equals(pelanggan)) {
                System.out.println(
                        "ID Reservasi: " + r.getIDReservasi() + ", Waktu Mulai: " + r.getWaktuMulai() + r.getPaket());
            }
        }
    }

    public void selesaikanReservasiByBarber(Barber barber, int id) {
        for (Reservasi r : reservasiList) {
            if (r.getBarber().equals(barber) && r.getIDReservasi() == id) {
                r.setStatus(true);
                System.out.println("Reservasi ID " + id + " telah diselesaikan oleh Barber " + barber.getUsername());
                return;
            }
        }
        System.out.println("Reservasi tidak ditemukan atau tidak sesuai dengan Barber.");
    }
}
