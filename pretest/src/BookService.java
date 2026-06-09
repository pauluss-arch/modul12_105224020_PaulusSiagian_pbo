public class BookService {
    public Book searchByTitle(String title) {
        System.out.println("Mencari buku: " + title);
        return new Book(title);
    }
}