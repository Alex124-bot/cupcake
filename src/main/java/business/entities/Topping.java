package business.entities;

public class Topping {
    int topping_id;
    String topping_name;
    int price;

    public int getTopping_id() {
        return topping_id;
    }

    public String getTopping_name() {
        return topping_name;
    }

    public int getPrice() {
        return price;
    }

    public Topping(int topping_id, String topping_name, int price) {
        this.topping_id = topping_id;
        this.topping_name = topping_name;
        this.price = price;
    }

    @Override
    public String toString() {
        return topping_name;
    }
}
