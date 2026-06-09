import java.util.ArrayList;

public class InMemoryTrainRepository implements TrainRepository {
    private ArrayList<Train> trainList;

    public InMemoryTrainRepository() {
        trainList = new ArrayList<>();
        trainList.add(new Train("K01", "Argo Bromo", "JKT - SBY", 50));
        trainList.add(new Train("K02", "Parahyangan", "JKT - BDG", 15));
    }

    @Override
    public ArrayList<Train> getAll() {
        return trainList;
    }

    @Override
    public Train findByCode(String code) throws RuteTidakDitemukanException {
        for (Train train : trainList) {
            if (train.hasCode(code)) {
                return train;
                    }
        }
        throw new RuteTidakDitemukanException("Kode kereta '" + code + "' tidak ditemukan dalam sistem!");
    }
}