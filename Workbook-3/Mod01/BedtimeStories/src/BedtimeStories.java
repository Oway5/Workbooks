import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class BedtimeStories {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Enter the name of the story you want to read");
        String fileName = x.nextLine();
        File name = new File(fileName+".txt");
        try (Scanner fileReader = new Scanner(name)) {
            int num = 1;
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(num + ". " + line);
                num++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found.");
        }
    }
}
