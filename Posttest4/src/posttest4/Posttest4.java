package posttest4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Posttest4 {
    static ArrayList<kamera> daftarKamera = new ArrayList<>();
    static ArrayList<aksesoris> daftarAksesoris = new ArrayList<>();
    static ArrayList<penyewaan> daftarPenyewaan = new ArrayList<>();
    
    static Scanner scanner = new Scanner(System.in);
    static int nextId = 1;
    static int nextIdPenyewaan = 1;

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\nPilih Menu:");
                System.out.println("1. Admin");
                System.out.println("2. User");
                System.out.println("3. Keluar");
                System.out.print("Pilihan: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); 

                switch (pilihan) {
                    case 1 -> menuAdmin();
                    case 2 -> menuUser();
                    case 3 -> {
                        System.out.println("Keluar dari program.");
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
    }

    public static void menuUser() {
        while (true) {
            System.out.println("\nMenu User:");
            System.out.println("1. Lihat Kamera");
            System.out.println("2. Lihat Aksesoris");
            System.out.println("3. Ajukan Penyewaan");
            System.out.println("4. Kembali");
            int pilihan = inputInteger("Pilih menu: ");

            switch (pilihan) {
                case 1 -> tampilkanKamera();
                case 2 -> tampilkanAksesoris();
                case 3 -> ajukanPenyewaan();
                case 4 -> { return; }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void menuAdmin() {
        while (true) {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Kelola Kamera");
            System.out.println("2. Kelola Aksesoris");
            System.out.println("3. Kelola Penyewaan");
            System.out.println("4. Kembali ke Menu Utama");
            int pilihan = inputInteger("Pilih menu: ");

            switch (pilihan) {
                case 1 -> menuCRUDKamera();
                case 2 -> menuCRUDAksesoris();
                case 3 -> kelolaPenyewaan();
                case 4 -> { return; }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }


    public static void menuCRUDKamera() {
        while (true) {
            System.out.println("\nMenu Kamera:");
            System.out.println("1. Tambah Kamera");
            System.out.println("2. Tampilkan Kamera");
            System.out.println("3. Update Kamera");
            System.out.println("4. Hapus Kamera");
            System.out.println("5. Kembali");
            int pilihan = inputInteger("Pilih menu: ");

            switch (pilihan) {
                case 1 -> tambahKamera();
                case 2 -> tampilkanKamera();
                case 3 -> updateKamera();
                case 4 -> hapusKamera();
                case 5 -> { return; }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void menuCRUDAksesoris() {
        while (true) {
            System.out.println("\nMenu Aksesoris:");
            System.out.println("1. Tambah Aksesoris");
            System.out.println("2. Tampilkan Aksesoris");
            System.out.println("3. Kembali");
            int pilihan = inputInteger("Pilih menu: ");

            switch (pilihan) {
                case 1 -> tambahAksesoris();
                case 2 -> tampilkanAksesoris();
                case 3 -> { return; }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void tambahKamera() {
        int id = nextId++;
        System.out.print("Masukkan Merk Kamera: ");
        String merk = scanner.nextLine();
        double harga = inputDouble("Masukkan Harga Kamera: ");
        boolean mirorless = inputBoolean("Apakah kamera mirorless? (true/false): ");
        boolean tipeSensor = inputBoolean("Apakah kamera bertipe full-frame? (true/false): ");
        daftarKamera.add(new kamera(id, merk, harga, true, mirorless, tipeSensor));
        System.out.println("Kamera berhasil ditambahkan!");
    }

    public static void tampilkanKamera() {
        daftarKamera.forEach(System.out::println);
    }

    public static void updateKamera() {
        int id = inputInteger("Masukkan ID Kamera yang akan diupdate: ");
        for (kamera k : daftarKamera) {
            if (k.getId() == id) {
                String merkBaru = inputString("Masukkan Merk Baru", k.getMerk());
                double hargaBaru = inputDouble("Masukkan Harga Baru: ");
                
                k.setMerk(merkBaru);
                k.setHarga(hargaBaru);
                System.out.println("Kamera berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Kamera tidak ditemukan.");
    }

    public static void hapusKamera() {
        int id = inputInteger("Masukkan ID Kamera yang akan dihapus: ");
        daftarKamera.removeIf(k -> k.getId() == id);
        System.out.println("Kamera berhasil dihapus.");
    }

    public static void tambahAksesoris() {
        int id = nextId++;
        System.out.print("Masukkan Merk Aksesoris: ");
        String merk = scanner.nextLine();
        double harga = inputDouble("Masukkan Harga Aksesoris: ");
        daftarAksesoris.add(new aksesoris(id, merk, harga, true));
        System.out.println("Aksesoris berhasil ditambahkan!");
    }
    
    public static void updateAksesoris() {
        int id = inputInteger("Masukkan ID Aksesoris yang akan diupdate: ");
        for (aksesoris a : daftarAksesoris) {
            if (a.getId() == id) {
                String merkBaru = inputString("Masukkan Merk Baru", a.getMerk());
                double hargaBaru = inputDouble("Masukkan Harga Baru: ");
                
                a.setMerk(merkBaru);
                a.setHarga(hargaBaru);
                System.out.println("Kamera berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Kamera tidak ditemukan.");
    }
    
    public static void hapusAksesoris() {
        int id = inputInteger("Masukkan ID Aksesoris yang akan dihapus: ");
        daftarAksesoris.removeIf(a -> a.getId() == id);
        System.out.println("Kamera berhasil dihapus.");
    }
    
    public static void tampilkanAksesoris() {
        daftarAksesoris.forEach(System.out::println);
    }
    
    public static void ajukanPenyewaan() {
    System.out.println("\nAjukan Penyewaan:");
    System.out.println("1. Kamera");
    System.out.println("2. Aksesoris");
    int pilihan = inputInteger("Pilih tipe barang: ");

    String tipe = "";
    int idBarang;

    switch (pilihan) {
        case 1:
            tipe = "kamera";
            tampilkanKamera();
            break;
        case 2:
            tipe = "aksesoris";
            tampilkanAksesoris();
            break;
        default:
            System.out.println("Pilihan tidak valid.");
            return;
    }

    idBarang = inputInteger("Masukkan ID Barang yang ingin disewa: ");
    daftarPenyewaan.add(new penyewaan(nextIdPenyewaan++, tipe, idBarang));
    System.out.println("Penyewaan berhasil diajukan.");
    }
    
    public static void kelolaPenyewaan() {
    System.out.println("\nDaftar Pengajuan Penyewaan:");
    for (penyewaan p : daftarPenyewaan) {
        System.out.println(p);
    }

    int idSewa = inputInteger("Masukkan ID Penyewaan yang akan disetujui: ");
    for (penyewaan p : daftarPenyewaan) {
        if (p.getId() == idSewa && !p.isDisetujui()) {
            boolean berhasil = false;
            if (p.getTipeBarang().equals("kamera")) {
                for (kamera k : daftarKamera) {
                    if (k.getId() == p.getIdBarang() && k.isStatus()) {
                        k.setStatus(false);
                        berhasil = true;
                    }
                }
            } else if (p.getTipeBarang().equals("aksesoris")) {
                for (aksesoris a : daftarAksesoris) {
                    if (a.getId() == p.getIdBarang() && a.isStatus()) {
                        a.setStatus(false);
                        berhasil = true;
                    }
                }
            }

            if (berhasil) {
                p.setDisetujui(true);
                System.out.println("Penyewaan telah disetujui dan barang diset status dipinjam.");
            } else {
                System.out.println("Barang tidak tersedia atau sudah disewa.");
            }

            return;
        }
    }

    System.out.println("Penyewaan tidak ditemukan atau sudah disetujui.");
    }

    
    public static int inputInteger(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                int angka = scanner.nextInt();
                scanner.nextLine();
                return angka;
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
    }
    
    public static double inputDouble(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                double angka = scanner.nextDouble();
                scanner.nextLine(); 
                return angka;
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka desimal!");
                scanner.nextLine(); 
            }
        }
    }

    public static boolean inputBoolean(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                return scanner.nextBoolean();
            } catch (InputMismatchException e) {
                System.out.println("Input harus 'true' atau 'false'!");
                scanner.nextLine(); 
            }
        }
    }
    
    public static String inputString(String pesan) {
        System.out.print(pesan);
        return scanner.nextLine();
    }

    public static String inputString(String pesan, String defaultValue) {
        System.out.print(pesan + " (" + defaultValue + "): ");
        String input = scanner.nextLine();
        return input.isEmpty() ? defaultValue : input;
    }
}