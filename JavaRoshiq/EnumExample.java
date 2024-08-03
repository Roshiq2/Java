enum Level{
    HIGH(3),MEDIUM(2),LOW(1);

    private final int levelCode;

    Level(int levelCode) {
        this.levelCode = levelCode;
    }

    public int getLevelCode() {
        return this.levelCode;
    }

    }

public class EnumExample {
    public static void main(String[] args) {
        Level level = Level.LOW;
        System.out.println(level.getLevelCode());
    }
}
