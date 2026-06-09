import java.util.ArrayList;

public class ReservationController {
    private TrainRepository repository;
    private PassengerValidator validator;

    public ReservationController(TrainRepository repository, PassengerValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public void displaySchedule() {
        System.out.println("\n=== JADWAL KERETA JAVA EXPRESS ===");
        ArrayList<Train> trains = repository.getAll();
        for (Train train : trains) {
            train.displayTrainInfo();
        }
    }

    public void bookTicket(String trainCode, String nik, String passengerName, int ticketAmount) 
            throws RuteTidakDitemukanException, TiketHabisException {
        
        validator.validate(nik);

        Train selectedTrain = repository.findByCode(trainCode);

        if (!selectedTrain.isSeatEnough(ticketAmount)) {
            selectedTrain.throwTiketHabisException();
        }

        selectedTrain.reduceSeats(ticketAmount);
        System.out.println("\n=================================");
        System.out.println("  RESERVASI TIKET BERHASIL!");
        System.out.println("=================================");
        System.out.println("Penumpang : " + passengerName);
        System.out.println("Jumlah    : " + ticketAmount + " Tiket");
        System.out.println("Status    : Lunas");
        System.out.println("=================================");
    }
}