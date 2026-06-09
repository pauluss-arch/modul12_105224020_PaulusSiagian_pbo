public class PassengerValidator {
    public void validate(String nik) {
        if (nik.length() != 16 || !nik.matches("\\d+")) {
            throw new DataPenumpangTidakValidException("NIK tidak valid! Harus tepat 16 karakter angka.");
        }
    }
}