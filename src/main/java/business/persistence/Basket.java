package business.persistence;

import business.entities.BasketItem;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<BasketItem> basket = new ArrayList<>();

    public Basket() {
    }

    public void add(BasketItem basketItem) {
        if (itemExists(basketItem)) getDublicateItem(basketItem).add(basketItem.getAmount());
        else basket.add(basketItem);
    }

    public void remove(BasketItem basketItem) {
        basket.remove(basketItem);
    }

    private boolean itemExists(BasketItem newItem) {
        for (BasketItem basketItem : basket) {
            if (basketItem.equals(newItem)) {
                basketItem.add(newItem.getAmount());
                return true;
            }
        }
        return false;
    }

    private BasketItem getDublicateItem(BasketItem newItem) {
        for (BasketItem basketItem : basket) {
            if (basketItem.equals(newItem)) {
                basketItem.add(newItem.getAmount());
                return basketItem;
            }
        }
        return null;
    }

}
