import java.util.ArrayList;

public interface TrainRepository {
    ArrayList<Train> getAll();
    Train findByCode(String code) throws RuteTidakDitemukanException;
}