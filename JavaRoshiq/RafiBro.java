class Parent1 {
    String str1 = "x";
    public Parent1() {
        parentMethod();
    }
    void parentMethod() {
        System.out.print(str1 + " ");
    }
}
class Child1 extends Parent1 {
    String str2 = "y";
    void parentMethod() {
        System.out.print(str2 + " ");
    }
}

public class RafiBro {
    public static void main(String[] args) {
        Child1 childOne = new Child1();
        childOne.parentMethod();
    }
}