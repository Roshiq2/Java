import java.util.stream.Stream;

@FunctionalInterface
interface Cat{
    void height(Cat cat);
    default void name(){
        System.out.println("Im a cat");
    }
}

public class Ros implements Cat{
    public static void main(String[] args) {
       Cat g=(animal)->animal.name();
       g.name();
       g.height(new Ros());

    }
    void name(Cat cat){
        System.out.println("Im a tiger");
    }
    @Override
    public void height(Cat cat) {

    }
}