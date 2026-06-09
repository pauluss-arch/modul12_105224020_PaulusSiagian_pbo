public class StandardFineCalculator implements FineCalculator {
    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 2000.0;
    }
}