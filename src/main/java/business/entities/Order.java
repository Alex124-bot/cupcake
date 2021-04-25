package business.entities;

public class Order {
    private int id, userId, created;

    public Order(int id, int userId, int created) {
        this.id = id;
        this.userId = userId;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getCreated() {
        return created;
    }
}
