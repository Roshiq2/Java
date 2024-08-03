record roshiq(int number,String name){
    roshiq(int number){
        this(number,null);
    }
    static String ros(){
        return "Roshiq Sabeer";
    }
}

public class RecordEx {
    public static void main(String[] args) {
        roshiq r=new roshiq(7);
        System.out.println(roshiq.ros()+r.name()+r.number());
    }

}
