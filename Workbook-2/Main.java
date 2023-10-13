public class Main {
    public static void main(String[] args) {
        double totalPrice = 0.0;
        Donut chocolate = new Donut("Chocolate", 300, 1.55, "Chocolate glaze covered");
        Donut vanilla = new Donut("Vanilla", 250, 1.88, "Vanilla glaze covered");
        Donut strawberry = new Donut("Strawberry", 280, 5.35, "Strawberry glaze covered");
        Donut pumpkin = new Donut("Pumpkin", 275, 1.41, "Pumpkin flavored donut");
        Donut glazed = new Donut("Glazed", 260, 0.99, "Plain donut covered in sugar glaze");
        Donut BostonCream = new Donut("BostonCream", 320, 1.65, "Donut with Boston cream inside");

        Donut[] donuts = {chocolate, vanilla, strawberry, pumpkin, glazed, BostonCream};
        System.out.println("Here are all the donuts:");
        for (Donut x : donuts) {
            System.out.println(x);
            totalPrice += x.price;
        }
        System.out.println("Total price of all donuts: $" + totalPrice);
    }
}
