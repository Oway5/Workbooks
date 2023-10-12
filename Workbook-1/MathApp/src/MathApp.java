public class MathApp {
    public static void main(String[] args) {
        // 1.
        double bobSalary = 50000;
        double garySalary = 60000;
        double highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("The highest salary is: $" + highestSalary);

        // 2.
        double carPrice = 25000;
        double truckPrice = 30000;
        double smallestPrice = Math.min(carPrice, truckPrice);
        System.out.println("The smallest price is: $" + smallestPrice);

        // 3.
        double radius = 7.25;
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("The area of the circle is: " + area);

        // 4.
        double number = 5.0;
        double squareRoot = Math.sqrt(number);
        System.out.println("The square root of " + number + " is: " + squareRoot);

        // 5.
        double x1 = 5, y1 = 10, x2 = 85, y2 = 50;
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("The distance between the points is: " + distance);

        // 6.
        double value = -3.8;
        double absoluteValue = Math.abs(value);
        System.out.println("The absolute value of " + value + " is: " + absoluteValue);

        // 7.
        double randomNumber = Math.random();
        System.out.println("Random number between 0 and 1: " + randomNumber);
    }
}
