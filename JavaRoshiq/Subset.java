public class Subset {

    static void ss(String p, String up){
        if(up.length()==0){
            System.out.println(p);

        }
        else {
            char c = up.charAt(0);
            ss(p + c, up.substring(1));
            ss(p, up.substring(1));
        }
    }
    public static void main(String[] args) {
        ss("","abc");
    }
}
