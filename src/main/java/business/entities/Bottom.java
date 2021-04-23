package business.entities;

public class Bottom {

    private int bottom_id;
    private String bottom_name;
    private int price;

    public Bottom(int bottom_id, String bottom_name, int price) {
        this.bottom_id = bottom_id;
        this.bottom_name = bottom_name;
        this.price = price;
    }

    public int getBottom_id() {
        return bottom_id;
    }

    public String getBottom_Name() {
        return bottom_name;
    }

    public int getPrice() {
        return price;
    }
}
