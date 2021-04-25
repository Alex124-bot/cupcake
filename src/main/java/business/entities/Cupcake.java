package business.entities;

public class Cupcake {

    private int cupcakeId, orderId, toppingId, bottomId, amount;

    public Cupcake(int id, int orderId, int toppingId, int bottomId, int amount) {
        this.cupcakeId = id;
        this.orderId = orderId;
        this.toppingId = toppingId;
        this.bottomId = bottomId;
        this.amount = amount;
    }

    public Cupcake(int orderId, int toppingId, int bottomId, int amount) {
        this.orderId = orderId;
        this.toppingId = toppingId;
        this.bottomId = bottomId;
        this.amount = amount;
    }

    public void setCupcakeId(int cupcakeId) {
        this.cupcakeId = cupcakeId;
    }

    public int getCupcakeId() {
        return cupcakeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public int getBottomId() {
        return bottomId;
    }

    public int getAmount() {
        return amount;
    }
}
