public class Donut {
    String type;
    int calories;
    double price;
    String description;

    public Donut(String type, int calories, double price, String description) {
        this.type = type;
        this.calories = calories;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "type = " + type + " donut" + "\n \tcalories:" + calories + ", price=" + price + ", description=" + description;
    }
}

