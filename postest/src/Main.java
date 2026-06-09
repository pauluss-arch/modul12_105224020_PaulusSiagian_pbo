public class Main {
    public static void main(String[] args) {
        Order customerOrder = new Order("ORD-9921", 150000);
        OrderRepository repository = new OrderRepository();
        PaymentMethod paymentMethod = new CreditCard(); 
        EmailNotifier emailNotifier = new EmailSystem();
        OrderService orderService = new OrderService(repository, paymentMethod, emailNotifier);
        orderService.processOrder(customerOrder, 150000);
    }
}
