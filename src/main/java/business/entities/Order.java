package business.entities;

import java.sql.Date;

public class Order {
    private int id, userId;
    Date created;

    public Order(int id, int userId, Date created) {
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

    public Date getCreated() {
        return created;
    }
}
