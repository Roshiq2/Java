import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

record Sam(Integer age, String name){}

public class ComparableEX {
    public static void main(String[] args) {
        Sam r=new Sam(5,"a");
        Sam r1=new Sam(2,"aaa");
        List<Integer> m=new ArrayList<>(List.of(5,6,4,3,2));
//        Collections.sort(m,(Sam a,Sam b)->a.name().compareTo(b.name()));
        System.out.println(m);
        System.out.println(m.stream().reduce((o, o2) -> o+o2));
    }
}



