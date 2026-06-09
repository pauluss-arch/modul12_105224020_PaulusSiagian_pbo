public class TextReceiptFormatter implements ReceiptFormatter {
    @Override
    public String formatReceipt(double fineAmount) {
        return "Total Denda: Rp " + fineAmount;
    }
}