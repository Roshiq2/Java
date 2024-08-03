import java.util.Scanner;

public class BinaryTree {
    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    private static Node root;
    void populate() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter root data: ");
        root =new Node(sc.nextInt());
        populate(sc,root);
    }
    void populate(Scanner sc,Node node){
        System.out.println("Insert at Left of "+node.data+": ");
        if(sc.nextInt()!=0){
            System.out.println("Enter data: ");
            int left=sc.nextInt();
            node.left=new Node(left);
            populate(sc,node.left);
        }
        System.out.println("Insert at Right: "+node.data+": ");
        if(sc.nextInt()!=0){
            System.out.println("Enter data: ");
            int right=sc.nextInt();
            node.right=new Node(right);
            populate(sc,node.right);
        }

    }
    void displayLeft(){
        Node temp=root;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.left;
        }
    }
    void displayright(){
        Node temp=root;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.right;
        }
    }
    void displayAll(Node node, int level){
        if(node==null)return;
        displayAll(node.right,level+1);

        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.println("|\t\t");
            }
            System.out.println("|------>"+node.data);
        }else{
            System.out.println(node.data);
        }
        displayAll(node.left,level+1);
    }

    public static void main(String[] args) {
        BinaryTree b=new BinaryTree();
        b.populate();
        b.displayLeft();
        b.displayAll(root,0);
    }

}
