import java.time.LocalDate;
import java.time.Month;

public class Test{
    public static void main(String pars[]) {
        LocalDate date1 = LocalDate.of(2016, Month.NOVEMBER, 11);
        LocalDate date2 = LocalDate.of(2016, 11, 12);
        System.out.println(date2.compareTo(date1));
    }
}