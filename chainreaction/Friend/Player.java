public class Player {
    char name;
    int count;

    public Player() {
        this.name = '-';
        this.count = 0;
    }

    @Override
    public String toString() {
        if(count==0){
            return " - ";
        }
        return name + "" + count;
    }
}
