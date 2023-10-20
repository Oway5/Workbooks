import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FormatDates {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter mmddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(mmddyyyy));
        DateTimeFormatter yyyymmdd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(now.format(yyyymmdd));
        DateTimeFormatter mmmmdyyyy = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(now.format(mmmmdyyyy));
        LocalDateTime gmtTime = LocalDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter idek = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        System.out.println(gmtTime.format(idek));
        DateTimeFormatter local = DateTimeFormatter.ofPattern("H:mm 'on' dd-MMM-yyyy");
        System.out.println(now.format(local));
    }
}