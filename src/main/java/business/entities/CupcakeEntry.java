package business.entities;

public class CupcakeEntry {

    private int cupcakeId;
    private int orderId;
    private int toppingId;
    private int bottomId;
    private int amount;

    public CupcakeEntry(int cupcakeId, int orderId, int toppingId, int bottomId, int amount) {
        this.cupcakeId = cupcakeId;
        this.orderId = orderId;
        this.toppingId = toppingId;
        this.bottomId = bottomId;
        this.amount = amount;
    }
}
