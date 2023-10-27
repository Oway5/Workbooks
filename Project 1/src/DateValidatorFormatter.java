import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidatorFormatter implements DateValidator {
    private String dateFormat;

    public DateValidatorFormatter(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try { sdf.parse(dateStr); } 
        catch (ParseException e) { return false; }
        return true;
    }
}