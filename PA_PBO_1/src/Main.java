import model.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Pelanggan> pelangganList = new ArrayList<>();
    static ArrayList<Barber> barberList = new ArrayList<>();
    static ArrayList<Admin> adminList = new ArrayList<>();
    static ArrayList<Paket> paketList = new ArrayList<>();
    // protected ArrayList<Reservasi> reservasiList = new ArrayList<>();
    static ManajemenReservasi manajemenReservasi = new ManajemenReservasi();

    static {
        // Data default pelanggan, admin
        pelangganList.add(new Pelanggan("akmal", "123", "0812345678"));
        adminList.add(new Admin("admin", "admin"));

        // Data default barber (3 data)
        barberList.add(new Barber("barber", "barber"));
        barberList.add(new Barber("barber2", "barber2"));
        barberList.add(new Barber("barber3", "barber3"));

        paketList.add(new Paket("Paket A", "cukur A", 50000));
        paketList.add(new Paket("Paket B", "cukur B", 60000));
        paketList.add(new Paket("Paket C", "cukur C", 70000));
    }

    public static void main(String[] args) {

        while (true) {
            util.clearConsole();
            System.out.println(util.GREEN + """
                    ███╗   ███╗███████╗███╗   ██╗██╗   ██╗    ██╗   ██╗████████╗ █████╗ ███╗   ███╗ █████╗
                    ████╗ ████║██╔════╝████╗  ██║██║   ██║    ██║   ██║╚══██╔══╝██╔══██╗████╗ ████║██╔══██╗
                    ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║    ██║   ██║   ██║   ███████║██╔████╔██║███████║
                    ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║    ██║   ██║   ██║   ██╔══██║██║╚██╔╝██║██╔══██║
                    ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝    ╚██████╔╝   ██║   ██║  ██║██║ ╚═╝ ██║██║  ██║
                    ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝      ╚═════╝    ╚═╝   ╚═╝  ╚═╝╚═╝     ╚═╝╚═╝  ╚═╝""");
            System.out.println(util.BLUE
                    + "========================================================================================="
                    + util.GREEN);
            System.out.println("   [1] Login");
            System.out.println("   [2] Register");
            System.out.println("   [3] Keluar" + util.BLUE);
            System.out
                    .println("========================================================================================="
                            + util.GREEN);
            int pilih = inputInteger(util.GREEN + "Pilih Menu : " + util.YELLOW);

            switch (pilih) {
                case 1:
                    loginMenu();
                    break;
                case 2:
                    registerMenu();
                    break;
                case 3:
                    util.clearConsole();
                    System.out.println(util.GREEN + """
                            ████████╗███████╗██████╗ ██╗███╗   ███╗ █████╗ ██╗  ██╗ █████╗ ███████╗██╗██╗  ██╗
                            ╚══██╔══╝██╔════╝██╔══██╗██║████╗ ████║██╔══██╗██║ ██╔╝██╔══██╗██╔════╝██║██║  ██║
                               ██║   █████╗  ██████╔╝██║██╔████╔██║███████║█████╔╝ ███████║███████╗██║███████║
                               ██║   ██╔══╝  ██╔══██╗██║██║╚██╔╝██║██╔══██║██╔═██╗ ██╔══██║╚════██║██║██╔══██║
                               ██║   ███████╗██║  ██║██║██║ ╚═╝ ██║██║  ██║██║  ██╗██║  ██║███████║██║██║  ██║
                               ╚═╝   ╚══════╝╚═╝  ╚═╝╚═╝╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝╚═╝  ╚═╝""");
                    return;
                default:
                    System.out.println(util.RED + "====================================================");
                    System.out.println("               PILIHAN TIDAK VALID!                 ");
                    System.out.println("====================================================");
                    util.delay(2000);
                    util.clearConsole();
            }
        }
    }

    static void loginMenu() {
        System.out.println(util.GREEN + """
                ██╗      ██████╗  ██████╗ ██╗███╗   ██╗
                ██║     ██╔═══██╗██╔════╝ ██║████╗  ██║
                ██║     ██║   ██║██║  ███╗██║██╔██╗ ██║
                ██║     ██║   ██║██║   ██║██║██║╚██╗██║
                ███████╗╚██████╔╝╚██████╔╝██║██║ ╚████║
                ╚══════╝ ╚═════╝  ╚═════╝ ╚═╝╚═╝  ╚═══╝""");
        System.out.println(util.BLUE + "====================================================");
        System.out.print(util.GREEN + "Username : " + util.YELLOW);
        String user = sc.nextLine();
        System.out.print(util.GREEN + "Password : " + util.YELLOW);
        String pass = sc.nextLine();

        // Cek admin
        for (Admin a : adminList) {
            if (a.login(user, pass)) {
                adminMenu(a);
                return;
            }
        }
        // Cek barber
        for (Barber b : barberList) {
            if (b.login(user, pass)) {
                barberMenu(b);
                return;
            }
        }
        // Cek pelanggan
        for (Pelanggan p : pelangganList) {
            if (p.login(user, pass)) {
                pelangganMenu(p);
                return;
            }
        }
        System.out.println(util.RED + "====================================================");
        System.out.println("                   LOGIN GAGAL!                     ");
        System.out.println("====================================================");
        util.delay(2000);
        util.clearConsole();
    }

    static void registerMenu() {
        System.out.println(util.GREEN + """
                ██████╗ ███████╗ ██████╗ ██╗███████╗
                ██╔══██╗██╔════╝██╔════╝ ██║██╔════╝
                ██████╔╝█████╗  ██║  ███╗██║███████╗
                ██╔══██╗██╔══╝  ██║   ██║██║╚════██║
                ██║  ██║███████╗╚██████╔╝██║███████║
                ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝╚══════╝""");
        System.out.println(util.BLUE + "====================================================");
        try {
            System.out.print(util.GREEN + "Username: " + util.YELLOW);
            String user = sc.nextLine();
            System.out.print(util.GREEN + "Password: " + util.YELLOW);
            String pass = sc.nextLine();

            // Validasi nomor telepon
            String telp;
            boolean validTelp = false;
            do {
                System.out.print(util.GREEN + "No Telp: " + util.YELLOW);
                telp = sc.nextLine();
                if (telp.matches("\\d+")) {
                    validTelp = true;
                } else {
                    System.out.println(util.RED + "====================================================");
                    System.out.println("        NOMOR TELEPON HARUS BERUPA ANGKA!           ");
                    System.out.println("====================================================");
                }
            } while (!validTelp);

            pelangganList.add(new Pelanggan(user, pass, telp));
            System.out.println("Registrasi berhasil!");
        } catch (Exception e) {
            System.out.println(util.RED + "====================================================");
            System.out.println("      TERJADI KESALAHAN INPUT, SILAHKAN ULANGI      ");
            System.out.println("====================================================");
            util.delay(2000);
            util.clearConsole();
            sc.nextLine();
        }
    }

    static void pelangganMenu(Pelanggan p) {
        while (true) {
            System.out.println(util.GREEN + """
                    ██████╗ ███████╗██╗      █████╗ ███╗   ██╗ ██████╗  ██████╗  █████╗ ███╗   ██╗
                    ██╔══██╗██╔════╝██║     ██╔══██╗████╗  ██║██╔════╝ ██╔════╝ ██╔══██╗████╗  ██║
                    ██████╔╝█████╗  ██║     ███████║██╔██╗ ██║██║  ███╗██║  ███╗███████║██╔██╗ ██║
                    ██╔═══╝ ██╔══╝  ██║     ██╔══██║██║╚██╗██║██║   ██║██║   ██║██╔══██║██║╚██╗██║
                    ██║     ███████╗███████╗██║  ██║██║ ╚████║╚██████╔╝╚██████╔╝██║  ██║██║ ╚████║
                    ╚═╝     ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝""");
            System.out.println(util.BLUE
                    + "================================================================================" + util.GREEN);
            System.out.println("   [1] Buat Reservasi");
            System.out.println("   [2] Lihat Detail Reservasi");
            System.out.println("   [3] Logout");
            System.out.println(
                    util.BLUE + "================================================================================");
            int pilih = inputInteger(util.GREEN + "Pilih Menu : " + util.YELLOW);

            switch (pilih) {
                case 1:
                    try {
                        Barber barberPilihan = null;
                        Paket paketPilihan = null;
                        while (true) {
                            // Pilih barber
                            System.out.printf(
                                    util.BLUE + "| " + util.GREEN + "%-3s" + util.BLUE + " | " + util.GREEN + "%-10s"
                                            + util.BLUE + " | " + util.GREEN + "%-15s" + util.BLUE + " |\n",
                                    "No", "ID", "Username");

                            System.out.println(util.BLUE + "-------------------------------------------");

                            for (int i = 0; i < barberList.size(); i++) {
                                Barber barber = barberList.get(i);
                                System.out.printf(
                                        util.BLUE + "| " + util.GREEN + "%-3d" + util.BLUE + " | " + util.GREEN
                                                + "%-10s" + util.BLUE + " | " + util.GREEN + "%-15s" + util.BLUE
                                                + " |\n",
                                        (i + 1), barber.getIDBarber(), barber.getUsername());
                            }

                            System.out
                                    .print(util.GREEN + "\nPilih barber (1-" + barberList.size() + "): " + util.YELLOW);
                            int pilihBarber = inputInteger(util.GREEN + "Pilih barber : " + util.YELLOW);

                            if (pilihBarber < 1 || pilihBarber > barberList.size()) {
                                System.out.println(util.RED + "====================================================");
                                System.out.println("           PILIHAN BARBER TIDAK VALID!              ");
                                System.out.println("====================================================");
                                continue;
                            }

                            barberPilihan = barberList.get(pilihBarber - 1);
                            break;
                        }

                        // Pilih paket
                        while (true) {
                            System.out.println(util.BLUE + "====================================================");
                            System.out.println(util.GREEN + "                     PILIH PAKET                    ");
                            System.out.println(util.BLUE + "====================================================");
                            System.out.printf(
                                    util.BLUE + "| " + util.GREEN + "%-3s" + util.BLUE + " | " + util.GREEN + "%-10s"
                                            + util.BLUE + " | " + util.GREEN + "%-15s" + util.BLUE + " | " + util.GREEN
                                            + "%-20s"
                                            + util.BLUE + " | " + util.GREEN + "%-10s" + util.BLUE + " |\n",
                                    "No", "ID", "Nama Paket", "Deskripsi", "Harga");
                            System.out.println(
                                    util.BLUE
                                            + "------------------------------------------------------------------------");
                            for (int i = 0; i < paketList.size(); i++) {
                                Paket paket = paketList.get(i);
                                System.out.printf(
                                        util.BLUE + "| " + util.GREEN + "%-3d" + util.BLUE + " | " + util.GREEN
                                                + "%-10s" + util.BLUE + " | " + util.GREEN + "%-15s" + util.BLUE + " | "
                                                + util.GREEN + "%-20s" + util.BLUE + " | " + util.GREEN + "Rp%-8d"
                                                + util.BLUE + " |\n",
                                        (i + 1), paket.getIDPaket(), paket.getNama(), paket.getDesk(),
                                        paket.getHarga());
                            }
                            System.out.println(
                                    util.BLUE
                                            + "------------------------------------------------------------------------");
                            System.out.print(util.GREEN + "\nPilih paket (1-" + paketList.size() + "): " + util.YELLOW);
                            int pilihPaket = inputInteger(util.GREEN + "Pilih paket : " + util.YELLOW);
                            if (pilihPaket < 1 || pilihPaket > paketList.size()) {
                                System.out.println(util.RED + "====================================================");
                                System.out.println("           PILIHAN PAKET TIDAK VALID!              ");
                                System.out.println("====================================================");
                                continue;
                            }
                            paketPilihan = paketList.get(pilihPaket - 1);
                            break;
                        }

                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        dateFormat.setLenient(false);

                        Date tanggalWaktu = null;

                        while (true) {
                            try {
                                // Input tanggal
                                System.out.print(util.GREEN + "Tanggal (dd/MM/yyyy): " + util.YELLOW);
                                String tanggal = sc.nextLine();

                                // Input waktu
                                System.out.print(util.GREEN + "Waktu (HH:mm): " + util.YELLOW);
                                String waktu = sc.nextLine();

                                // Gabungkan & parse
                                tanggalWaktu = dateFormat.parse(tanggal + " " + waktu);
                                if (tanggalWaktu.before(new Date())) {
                                    System.out
                                            .println(util.RED + "====================================================");
                                    System.out.println("            TANGGAL/WAKTU TIDAK BOLEH LAMPAU        ");
                                    System.out.println("====================================================");
                                    continue;
                                }
                                break;

                            } catch (ParseException e) {
                                System.out.println(util.RED + "====================================================");
                                System.out.println("         FORMAT TANGGAL / WAKTU TIDAK VALID!        ");
                                System.out.println("         Gunakan format dd/MM/yyyy dan HH:mm        ");
                                System.out.println("====================================================");
                            }
                        }
                        Reservasi reservasi = new Reservasi(tanggalWaktu, barberPilihan, p, paketPilihan);

                        manajemenReservasi.tambahReservasi(reservasi);

                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println("              INPUT RESERVASI GAGAL                 ");
                        System.out.println("====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                case 2:
                    manajemenReservasi.getReservasiByPelanggan(p);
                    break;
                case 3:
                    p.logout();
                    return;
                default:
                    System.out.println(util.RED + "====================================================");
                    System.out.println("               PILIHAN TIDAK VALID!                 ");
                    System.out.println("====================================================");
                    util.delay(2000);
                    util.clearConsole();
            }
        }
    }

    static void adminMenu(Admin a) {
        while (true) {
            System.out.println(util.GREEN + """
                     █████╗ ██████╗ ███╗   ███╗██╗███╗   ██╗
                    ██╔══██╗██╔══██╗████╗ ████║██║████╗  ██║
                    ███████║██║  ██║██╔████╔██║██║██╔██╗ ██║
                    ██╔══██║██║  ██║██║╚██╔╝██║██║██║╚██╗██║
                    ██║  ██║██████╔╝██║ ╚═╝ ██║██║██║ ╚████║
                    ╚═╝  ╚═╝╚═════╝ ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝""");
            System.out.println(util.BLUE + "====================================================");
            System.out.println(util.GREEN + "   [1] Lihat Reservasi");
            System.out.println("   [2] Lihat Barber");
            System.out.println("   [3] Tambah Barber");
            System.out.println("   [4] Update Barber");
            System.out.println("   [5] Hapus Barber");
            System.out.println("   [0] Logout");
            System.out.println(util.BLUE + "====================================================");

            int pilih = inputInteger(util.GREEN + "Pilih Menu : " + util.YELLOW);
            switch (pilih) {
                case 1:
                    manajemenReservasi.getAllReservasi();
                    break;
                case 2:
                    Barber.TampilBarber(barberList);
                    break;
                case 3:
                    try {
                        System.out.print(util.GREEN + "Username Barber: " + util.YELLOW);
                        String userB = sc.nextLine();
                        System.out.print(util.GREEN + "Password: " + util.YELLOW);
                        String passB = sc.nextLine();
                        barberList.add(new Barber(userB, passB));
                        System.out.println(util.BLUE + "====================================================");
                        System.out.println(util.GREEN + "           BARBER BERHASIL DITAMBAHKAN!             ");
                        System.out.println(util.BLUE + "====================================================");
                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println("                INPUT BARBER GAGAL!                 ");
                        System.out.println("====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                case 4:
                    Barber.TampilBarber(barberList);
                    int id = inputInteger(util.GREEN + "Masukkan ID Barber yang akan diupdate: " + util.YELLOW);
                    for (Barber b : barberList) {
                        if (b.getIDBarber() == id) {
                            System.out.print(util.GREEN + "Username Baru Barber: " + util.YELLOW);
                            String namaBaru = sc.nextLine();

                            b.setNamaBarber(namaBaru);
                            System.out.println(util.BLUE + "====================================================");
                            System.out.println(util.GREEN + "             BARBER BERHASIL DIUPDATE!              ");
                            System.out.println(util.BLUE + "====================================================");
                            return;
                        }
                    }
                    System.out.println(util.RED + "====================================================");
                    System.out.println("              BARBER TIDAK DITEMUKAN!               ");
                    System.out.println("====================================================");
                    break;
                case 5:
                    try {
                        System.out.print(util.GREEN + "Username Barber: " + util.YELLOW);
                        String userDel = sc.nextLine();
                        barberList.removeIf(b -> b.getUsername().equals(userDel));
                        System.out.println(util.BLUE + "====================================================");
                        System.out.println(util.GREEN + "             BARBER BERHASIL DIHAPUS!               ");
                        System.out.println(util.BLUE + "====================================================");
                    } catch (Exception e) {
                        System.out.println(util.RED + "====================================================");
                        System.out.println("             INPUT HAPUS BARBER GAGAL!              ");
                        System.out.println("====================================================");
                        util.delay(2000);
                        util.clearConsole();
                        sc.nextLine();
                    }
                    break;
                case 6:
                    a.logout();
                    return;
                default:
                    System.out.println(util.RED + "====================================================");
                    System.out.println("               PILIHAN TIDAK VALID!                 ");
                    System.out.println("====================================================");
                    util.delay(2000);
                    util.clearConsole();
            }
        }
    }

    static void barberMenu(Barber b) {
        while (true) {
            System.out.println(util.GREEN + """
                    ██████╗  █████╗ ██████╗ ██████╗ ███████╗██████╗
                    ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔══██╗
                    ██████╔╝███████║██████╔╝██████╔╝█████╗  ██████╔╝
                    ██╔══██╗██╔══██║██╔══██╗██╔══██╗██╔══╝  ██╔══██╗
                    ██████╔╝██║  ██║██║  ██║██████╔╝███████╗██║  ██║
                    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚═╝  ╚═╝""");
            System.out.println(util.BLUE + "====================================================");
            System.out.println(util.GREEN + "   [1] Lihat Reservasi Hari Ini");
            System.out.println("   [2] Logout");
            System.out.println(util.BLUE + "====================================================");
            int pilih = inputInteger(util.GREEN + "Pilih Menu : " + util.YELLOW);

            switch (pilih) {
                case 1:
                    manajemenReservasi.getReservasiByBarber(b);
                    break;
                case 2:
                    int id = inputInteger(util.GREEN + "Masukkan ID Reservasi yang sudah selesai: " + util.YELLOW);
                    manajemenReservasi.selesaikanReservasiByBarber(b, id);
                    System.out.println(util.BLUE + "====================================================");
                    System.out.println(util.GREEN + "             RESERVASI SELESAI!                    ");
                    System.out.println(util.BLUE + "====================================================");
                    util.delay(2000);
                    break;
                case 3:
                    b.logout();
                    return;
                default:
                    System.out.println(util.RED + "====================================================");
                    System.out.println("               PILIHAN TIDAK VALID!                 ");
                    System.out.println("====================================================");
                    util.delay(2000);
                    util.clearConsole();
            }
        }
    }

    public static int inputInteger(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                int angka = sc.nextInt();
                sc.nextLine();
                return angka;
            } catch (InputMismatchException e) {
                System.out.println(util.RED + "====================================================");
                System.out.println("            INPUT HARUS BERUPA ANGKA!               ");
                System.out.println("====================================================");
                sc.nextLine();
                continue;
            }
        }
    }
}