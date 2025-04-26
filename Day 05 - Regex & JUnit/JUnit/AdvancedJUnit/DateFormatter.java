package Day3.JUnit.AdvancedJUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateFormatter {
    public String formatDate(String inputDate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            return null;
        }
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {
    DateFormatter dateFormatter = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("28-04-2025", dateFormatter.formatDate("2025-04-28"));
        assertEquals("01-01-2020", dateFormatter.formatDate("2020-01-01"));
        assertEquals("15-08-1995", dateFormatter.formatDate("1995-08-15"));
    }

    @Test
    void testInvalidDate() {
        assertNull(dateFormatter.formatDate("2025-13-28"));
        assertNull(dateFormatter.formatDate("2025-04-31"));
        assertNull(dateFormatter.formatDate("2025-02-30"));
        assertNull(dateFormatter.formatDate("2025-04-28 12:00"));
        assertNull(dateFormatter.formatDate("NotADate"));
    }
}
