package posttest3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Posttest3 {
    static ArrayList<Kamera> daftarKamera = new ArrayList<>();
    static ArrayList<Aksesoris> daftarAksesoris = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);
    static int nextId = 1;

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
        System.out.println("Coming Soon");
        tampilkanKamera();
    }

    public static void menuAdmin() {
        while (true) {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Kelola Kamera");
            System.out.println("2. Kelola Aksesoris");
            System.out.println("3. Kembali ke Menu Utama");
            int pilihan = inputInteger("Pilih menu: ");

            switch (pilihan) {
                case 1 -> menuCRUDKamera();
                case 2 -> menuCRUDAksesoris();
                case 3 -> { return; }
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
        daftarKamera.add(new Kamera(id, merk, harga, true, mirorless, tipeSensor));
        System.out.println("Kamera berhasil ditambahkan!");
    }

    public static void tampilkanKamera() {
        daftarKamera.forEach(System.out::println);
    }

    public static void updateKamera() {
        int id = inputInteger("Masukkan ID Kamera yang akan diupdate: ");
        for (Kamera k : daftarKamera) {
            if (k.getId() == id) {
                System.out.print("Masukkan Merk Baru: ");
                k.setMerk(scanner.nextLine());
                k.setHarga(inputDouble("Masukkan Harga Baru: "));
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
        daftarAksesoris.add(new Aksesoris(id, merk, harga, true));
        System.out.println("Aksesoris berhasil ditambahkan!");
    }
    
    public static void tampilkanAksesoris() {
        daftarAksesoris.forEach(System.out::println);
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
}