public class Train {
    private String code;
    private String name;
    private String route;
    private int availableSeats;

    public Train(String code, String name, String route, int availableSeats) {
        this.code = code;
        this.name = name;
        this.route = route;
        this.availableSeats = availableSeats;
    }

    public boolean hasCode(String targetCode) {
        return this.code.equalsIgnoreCase(targetCode);
    }

    public boolean isSeatEnough(int requestedTickets) {
        return this.availableSeats >= requestedTickets;
    }

    public void reduceSeats(int amount) {
        this.availableSeats -= amount;
    }

    public void displayTrainInfo() {
        System.out.println("[" + code + "] " + name + " (" + route + ") | Sisa Kursi: " + availableSeats);
    }

    public void throwTiketHabisException() throws TiketHabisException {
        throw new TiketHabisException(this.name, this.availableSeats);
    }
}