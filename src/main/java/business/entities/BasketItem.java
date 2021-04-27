package business.entities;

import java.util.Objects;

public class BasketItem {
    private int toppingId, bottomId, amount;

    public BasketItem(int toppingId, int bottomId, int amount) {
        this.toppingId = toppingId;
        this.bottomId = bottomId;
        this.amount = amount;
    }

    public BasketItem() {
        this.toppingId = -1;
        this.bottomId = -1;
        this.amount = -1;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void add(int amount) {
        this.amount += amount;
    }

    public void subtract(int amount) {
        this.amount -= amount;
    }

    public boolean isValid() {
        return toppingId > 0 && bottomId > 0 && amount > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketItem that = (BasketItem) o;
        return toppingId == that.toppingId &&
                bottomId == that.bottomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toppingId, bottomId);
    }
}
