public class OrderService {
    private OrderRepository repository;
    private PaymentMethod payment;
    private EmailNotifier notifier;

    public OrderService(OrderRepository repository, PaymentMethod payment, EmailNotifier notifier) {
        this.repository = repository;
        this.payment = payment;
        this.notifier = notifier;
    }

    public void processOrder(Order order, double amount) {
        repository.save(order);
        payment.pay(amount);
        notifier.sendEmail();
    }
}