public class BST {
    private static class Node{
        int value;
        Node left;
        Node right;
        int height;
        public Node(int data) {
            this.value = data;
        }
    }
    private static Node root;

    public static void insert(int value){
        root=insert(value,root);
    }

    public static int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    private static Node insert(int value,Node node){
        if(node==null){
            node=new Node(value);
            return node;
        }
        else if(value>node.value){
            node.left=insert(value,node.left);
        }else{
            node.right=insert(value,node.right);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }

    public void balanced(){
        balanced(root);
    }
    public boolean balanced(Node node){
        if(node==null) return false;
        return Math.abs(height(node.left)-height(node.right))<=1
                && balanced(node.left) && balanced(node.right);
    }

    void displayAll(Node node, int level){
        if(node==null)return;
        displayAll(node.right,level+1);

        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.println("|\t\t");
            }
            System.out.println("|------>"+node.value);
        }else{
            System.out.println(node.value);
        }
        displayAll(node.left,level+1);
    }
    void preOrder(Node node){
        if(node==null)return;
        System.out.println(node.value +" "+ height(node));
        preOrder(node.left);
        preOrder(node.right);
    }
    void InOrder(Node node){
        if(node==null)return;

        InOrder(node.left);
        System.out.println(node.value);
        InOrder(node.right);
    }
    void postOrder(Node node){
        if(node==null)return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value+" "+ height(node));
    }
    public static void main(String[] args) {
        BST b=new BST();
        int[] arr={15,10,20,5,12,8};
        populate(arr);
        b.postOrder(root);

    }

    private static void populate(int[] arr) {
        for(int a:arr) insert(a);
    }


}
