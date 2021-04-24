package business.entities;

public class Order {
    int orderId;
    int userId;
    int created;
    int completed;

    public Order(int orderId, int userId, int created, int completed) {
        this.orderId = orderId;
        this.userId = userId;
        this.created = created;
        this.completed = completed;
    }
}
