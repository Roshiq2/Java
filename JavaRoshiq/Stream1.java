import java.util.List;
import java.util.stream.Collectors;

public class Stream1 {
    public static void main(String[] args) {
        List<Integer> s=List.of(1,2,3);
        System.out.println(s.stream().sorted((o1, o2) -> o2-o1).collect(Collectors.toList()));
    }
}
