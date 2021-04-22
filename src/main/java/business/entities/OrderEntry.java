package business.entities;

import java.sql.Timestamp;

public class OrderEntry {
    private int order_id;
    private int user_id;
    private int created;
    private int completed;

    public OrderEntry(int order_id, int user_id, int created, int completed) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.created = created;
        this.completed = completed;
    }
}
