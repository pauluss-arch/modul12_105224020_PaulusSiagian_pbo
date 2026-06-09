public class TableReceiptFormatter implements ReceiptFormatter {
    @Override
    public String formatReceipt(double fineAmount) {
        return "|   INFO TAGIHAN    |\n" +
               "| Denda  | Rp " + fineAmount + " |\n" ;
    }
}