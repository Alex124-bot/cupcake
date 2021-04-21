package business.entities;

public class Topping {
    private int id;
    private String name;
    private int price;

    public Topping(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
