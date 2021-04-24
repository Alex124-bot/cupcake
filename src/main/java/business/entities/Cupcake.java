package business.entities;

public class Cupcake {

     int cupcakeId;
     int orderId;
     int toppingId;
     int bottomId;
     int amount;

    public Cupcake(int cupcakeId, int orderId, int toppingId, int bottomId, int amount) {
        this.cupcakeId = cupcakeId;
        this.orderId = orderId;
        this.toppingId = toppingId;
        this.bottomId = bottomId;
        this.amount = amount;
    }
}
