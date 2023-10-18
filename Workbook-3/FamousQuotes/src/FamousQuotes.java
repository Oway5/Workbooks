import java.util.Scanner;
import java.util.Random;
public class FamousQuotes {

    public static void main(String[] args) {
        boolean continueLoop = true;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] quotes = {
                "“Stupidity isn’t a virus, but it sure is spreading like one.” – Sandy",
                "“East? I thought you said Weest” - Patric",
                "“You never really know the true value of a moment, until it becomes a memory.” – SpongeBob",
                "“I’ll have you know that I stubbed by toe last week and only cried for 20 minutes.“ – SpongeBob",
                "“Goodbye everyone, I’ll remember you all in therapy.” – Plankton",
                "“You can’t fool me. I listen to public radio!” – Squidward",
                "“Remember, licking doorknobs is illegal on other planets.” – SpongeBob",
                "“Well, it’s no secret that the best thing about a secret is secretly telling someone your secret, thereby adding another secret to their secret collection of secrets, secretly.” – SpongeBob",
                "“Gary, I’m absorbing his blows like I’m made of some sort of spongy material.” – SpongeBob",
                "“Who you callin' a pin head?” - Patrick"
        };
        while (continueLoop) {
            System.out.print("Enter a number between 1 and 10 (or 0 for a random quote):");
            int selectedNumber = scanner.nextInt();
            if (selectedNumber >= 1 && selectedNumber <= 10) {
                System.out.println(quotes[selectedNumber - 1]);
            }
            else if (selectedNumber ==0) {
                int randomIndex = random.nextInt(10);
                System.out.println(quotes[randomIndex]);
            }
            else {
                System.out.println("Number must be between 1 and 10, or 0 for a random quote.");
            }
            System.out.print("Do you want to see another quote? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                continueLoop = false;
            }
        }

        scanner.close();
    }
}