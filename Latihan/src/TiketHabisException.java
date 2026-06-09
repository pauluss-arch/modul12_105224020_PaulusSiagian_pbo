public class TiketHabisException extends Exception {
    private String namaKereta;
    private int sisaKursi;

    public TiketHabisException(String namaKereta, int sisaKursi) {
        super("Gagal! Tiket habis atau tidak mencukupi.");
        this.namaKereta = namaKereta;
        this.sisaKursi = sisaKursi;
    }

    public void tampilkanDetailError() {
        System.out.println("Detail Error -> Kereta: " + namaKereta + " | Sisa Kursi: " + sisaKursi);
    }
}