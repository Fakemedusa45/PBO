package posttest1;

import java.util.ArrayList;
import java.util.Scanner;

public class Posttest1 {
    static ArrayList<kamera> daftarKamera = new ArrayList<>();
    static ArrayList<aksesoris> daftarAksesoris = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int nextId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPilih Menu:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = scanner.nextInt();
            
            switch (pilihan) {
                case 1:
                    menuAdmin();
                    break;
                case 2:
                    menuUser();
                    break;
                case 3:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void menuAdmin() {
        while (true) {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Kelola Kamera");
            System.out.println("2. Kelola Aksesoris");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    menuCRUDKamera();
                    break;
                case 2:
                    menuCRUDAksesoris();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
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
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahKamera();
                    break;
                case 2:
                    tampilkanKamera();
                    break;
                case 3:
                    updateKamera();
                    break;
                case 4:
                    hapusKamera();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    
     public static void menuCRUDAksesoris() {
        while (true) {
            System.out.println("\nMenu Aksesoris:");
            System.out.println("1. Tambah Aksesoris");
            System.out.println("2. Tampilkan Aksesoris");
            System.out.println("3. Update Aksesoris");
            System.out.println("4. Hapus Aksesoris");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahAksesoris();
                    break;
                case 2:
                    tampilkanAksesoris();
                    break;
                case 3:
                    updateAksesoris();
                    break;
                case 4:
                    hapusAksesoris();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void menuUser() {
        System.out.println("Coming Soon");
        tampilkanKamera();
    }

    public static void tambahKamera() {
        int id = nextId++;
        System.out.print("Masukkan Merk Kamera: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan Harga Kamera: ");
        double harga = scanner.nextDouble();
        System.out.print("Apakah kamera mirorless? (true/false): ");
        boolean mirorless = scanner.nextBoolean();
        System.out.print("Apakah kamera bertipe fullframe? (true/false): ");
        boolean tipeSensor = scanner.nextBoolean();
        boolean status = true;

        daftarKamera.add(new kamera(id, merk, harga, status, mirorless, tipeSensor));
        System.out.println("Kamera berhasil ditambahkan dengan ID: " + id);
    }

    public static void tampilkanKamera() {
        if (daftarKamera.isEmpty()) {
            System.out.println("Tidak ada kamera.");
        } else {
            for (kamera k : daftarKamera) {
                System.out.println(k);
            }
        }
    }

    public static void updateKamera() {
        System.out.print("Masukkan ID Kamera yang akan diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (kamera k : daftarKamera) {
            if (k.idKamera == id) {
                System.out.print("Masukkan Merk Baru: ");
                k.merkKamera = scanner.nextLine();
                System.out.print("Masukkan Harga Baru: ");
                k.hargaKamera = scanner.nextDouble();
                System.out.print("Apakah kamera mirorless? (true/false): ");
                k.mirorless = scanner.nextBoolean();
                System.out.print("Apakah kamera bertipe fullframe? (true/false): ");
                k.tipeSensor = scanner.nextBoolean();
                System.out.print("Apakah kamera tersedia? (true/false): ");
                k.statusKamera = scanner.nextBoolean();
                System.out.println("Kamera berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Kamera tidak ditemukan.");
    }

    public static void hapusKamera() {
        System.out.print("Masukkan ID Kamera yang akan dihapus: ");
        int id = scanner.nextInt();

        for (int i = 0; i < daftarKamera.size(); i++) {
            if (daftarKamera.get(i).idKamera == id) {
                daftarKamera.remove(i);
                System.out.println("Kamera berhasil dihapus.");
                return;
            }
        }
        System.out.println("Kamera tidak ditemukan.");
    }


 public static void tambahAksesoris() {
        int id = nextId++;
        System.out.print("Masukkan Merk Aksesoris: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan Harga Aksesoris: ");
        double harga = scanner.nextDouble();
        boolean status = true;
        
        daftarAksesoris.add(new aksesoris(id, merk, harga, status));
        System.out.println("Aksesoris berhasil ditambahkan dengan ID: " + id);
    }

    public static void tampilkanAksesoris() {
        if (daftarAksesoris.isEmpty()) {
            System.out.println("Tidak ada aksesoris.");
        } else {
            for (aksesoris a : daftarAksesoris) {
                System.out.println(a);
            }
        }
    }

    public static void updateAksesoris() {
        System.out.print("Masukkan ID Aksesoris yang akan diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (aksesoris a : daftarAksesoris) {
            if (a.idAksesoris == id) {
                System.out.print("Masukkan Merk Baru: ");
                a.merkAksesoris = scanner.nextLine();
                System.out.print("Masukkan Harga Baru: ");
                a.hargaAksesoris = scanner.nextDouble();
                System.out.print("Apakah aksesoris tersedia? (true/false): ");
                a.statusAksesoris = scanner.nextBoolean();
                System.out.println("Aksesoris berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Aksesoris tidak ditemukan.");
    }
    
    public static void hapusAksesoris() {
        System.out.print("Masukkan ID Aksesoris yang akan dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (aksesoris a : daftarAksesoris) {
            if (a.idAksesoris == id) {
                daftarAksesoris.remove(a);
                System.out.println("Aksesoris berhasil dihapus.");
                return;
            }
        }
        System.out.println("Aksesoris tidak ditemukan.");
    }
}

