package business.entities;

public class BasketItem {
    private int toppingId, bottomId, amount;

    public BasketItem(int toppingId, int bottomId, int amount) {
        this.toppingId = toppingId;
        this.bottomId = bottomId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "toppingId#" + toppingId +
                ", bottomId#" + bottomId +
                ", amount#" + amount;
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

    public void add(int amount) {
        this.amount += amount;
    }


}
