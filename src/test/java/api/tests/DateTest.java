package api.tests;

import com.sun.org.apache.xpath.internal.operations.Lte;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        String dateInStringFormat = formatter.format(date);//this line demonstrates that format method returns a string

        System.out.println(dateInStringFormat);

        //This prints mm/dd/yyyy, which is the format you use at Hilton

        //so you do calendarWebElement.sendKeys( formatter.format(date) );


    }
}
