package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSelection
{
    public static String SelectDepartureDate(String m)
    {
        Date date= new Date();
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");

        Calendar calendar= Calendar.getInstance();
        calendar.add(Calendar.DATE, Integer.parseInt(m));
        return dateFormat.format(calendar.getTime());
    }

    public static String SelectReturnDate(String n)
    {
        Date date= new Date();
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");

        Calendar calendar= Calendar.getInstance();
        calendar.add(Calendar.DATE, Integer.parseInt(n));
        return dateFormat.format(calendar.getTime());
    }

    public static void main(String[] args) {
        System.out.println(SelectDepartureDate("3"));
        System.out.println(SelectReturnDate("9"));
    }
}
