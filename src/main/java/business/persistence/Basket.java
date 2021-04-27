package business.persistence;

import business.entities.BasketItem;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<BasketItem> basket;

    public Basket() {
        basket = new ArrayList<>();
    }


    public void add(BasketItem basketItem) {
        if (itemExists(basketItem)) getDublicateItem(basketItem).add(basketItem.getAmount());
        else basket.add(basketItem);
    }

    public void subtract(BasketItem basketItem) {
        if (itemExists(basketItem)) {
            getDublicateItem(basketItem).subtract(basketItem.getAmount());
            if (getDublicateItem(basketItem).getAmount() <= 0) remove(basketItem);
        }
    }

    public void remove(BasketItem basketItem) {
        basket.remove(getDublicateItem(basketItem));
    }

    private boolean itemExists(BasketItem newItem) {
        for (BasketItem basketItem : basket) {
            if (basketItem.equals(newItem)) return true;
        }
        return false;
    }

    private BasketItem getDublicateItem(BasketItem newItem) {
        for (BasketItem basketItem : basket) {
            if (basketItem.equals(newItem)) return basketItem;
        }
        return null;
    }

    public List<BasketItem> getList() {
        return basket;
    }
}
