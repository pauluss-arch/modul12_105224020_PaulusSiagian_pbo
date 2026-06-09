import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            TrainRepository repository = new InMemoryTrainRepository();
            PassengerValidator validator = new PassengerValidator();
            ReservationController controller = new ReservationController(repository, validator);
            
            int menuChoice = 0;
            System.out.println("Selamat Datang di Sistem Reservasi Java Express!");

            try {
                while (menuChoice != 3) {
                    System.out.println("\nMENU UTAMA:");
                    System.out.println("1. Lihat Jadwal Kereta");
                    System.out.println("2. Pesan Tiket");
                    System.out.println("3. Keluar");
                    System.out.print("Pilih Menu (Angka): ");

                    try {
                        menuChoice = input.nextInt();
                        input.nextLine();

                        switch (menuChoice) {
                            case 1:
                                controller.displaySchedule();
                                break;

                            case 2:
                                System.out.println("\n--- FORMULIR PEMESANAN TIKET ---");
                                System.out.print("Masukkan Kode Kereta: ");
                                String code = input.nextLine();

                                System.out.print("Masukkan NIK Penumpang: ");
                                String nik = input.nextLine();

                                System.out.print("Masukkan Nama Penumpang: ");
                                String name = input.nextLine();

                                System.out.print("Masukkan Jumlah Tiket: ");
                                int amount = input.nextInt();
                                input.nextLine(); 

                                controller.bookTicket(code, nik, name, amount);
                                break;

                            case 3:
                                System.out.println("Memproses penutupan sesi aplikasi...");
                                break;

                            default:
                                System.out.println("Pilihan menu tidak tersedia. Silakan coba lagi.");
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Error Input: Mohon masukkan angka saja, jangan huruf atau simbol!");
                        input.nextLine(); 
                    } catch (DataPenumpangTidakValidException e) {
                        System.out.println("Gagal Validasi Penumpang: " + e.getMessage());
                    } catch (RuteTidakDitemukanException e) {
                        System.out.println("Gagal Validasi Rute: " + e.getMessage());
                    } catch (TiketHabisException e) {
                        System.out.println("Gagal Validasi Kursi: " + e.getMessage());
                        e.tampilkanDetailError();
                    }
                }
            } finally {
                System.out.println("\n[Sistem] Terima kasih telah menggunakan layanan 'JAVA EXPRESS'. Sampai jumpa!");
                input.close();
            }
        }
    }
}