package business.entities;

public class CupcakeEntry {

     int cupcakeId;
     int orderId;
     int toppingId;
     int bottomId;
     int amount;

    public CupcakeEntry(int cupcakeId, int orderId, int toppingId, int bottomId, int amount) {
        this.cupcakeId = cupcakeId;
        this.orderId = orderId;
        this.toppingId = toppingId;
        this.bottomId = bottomId;
        this.amount = amount;
    }
}
