class Parent {
    String str1 = "x";

    public Parent() {
        parentMethod();
    }

    void parentMethod() {
        System.out.print(str1 + " ");
    }
}

class Child extends Parent {
    String str2 = "y";
    Child(){
        super();
        System.out.println("Roshiq");

        System.out.println("Sabeer");
    }

    void parentMethod() {
        System.out.print(str2 + " ");
    }
}

public class Tester {

    public static void main(String[] args) {
        Child childOne = new Child();
        childOne.parentMethod();
    }
}