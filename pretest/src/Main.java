public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        LoanService loanService = new LoanService();
        
        FineCalculator fineCalculator = new StandardFineCalculator();
        ReceiptFormatter receiptFormatter = new TableReceiptFormatter();

        Member member = new Member("M001");
        Book book = bookService.searchByTitle("Pemrograman Berorientasi Objek");
        
        loanService.processLoan(member, book);

        double totalFine = fineCalculator.calculateFine(5);
        String printedReceipt = receiptFormatter.formatReceipt(totalFine);
        
        System.out.println(printedReceipt);
    }
}