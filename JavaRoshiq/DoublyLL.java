class Node{
    private String data;
    private Node next;

    public String getData() {
        return data;
    }
    private Node prev;

    public Node(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }


}



public class DoublyLL {
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    void addBeg(String data){
        Node node = new Node(data);
        if(head==null){
            head=tail=node;
        }else{
            node.setNext(head);
            head.setPrev(node);
            head=node;
        }
    }
    void displayEnd(){
        Node temp=this.tail;
        while(temp!=null){
            System.out.print(temp.getData()+" ,");
            temp=temp.getPrev();
        }
    }
    void displayStart(){
        Node temp=this.head;
        while(temp!=null){
            System.out.print(temp.getData()+" ,");
            temp=temp.getNext();
        }
    }
    void addAtLast(String data){
        Node node=new Node(data);
        if(head==null){
            head=tail=node;
        }else{
            tail.setNext(node);
            node.setPrev(tail);
            tail=node;

        }

    }
    void deleteElement(String e){
        Node temp=this.tail;
        while(temp!=null){
            if(temp.getData().equals(e)){
                Node p=temp.getPrev();
                p.setNext(temp.getNext());
                temp.getNext().setPrev(p);
                return;
            }
            temp=temp.getPrev();
        }
    }
    int length(){
        Node temp=this.head;
        int l=0;
        while(temp!=null){
            l+=1;
            temp=temp.getNext();
        }
        return l;
    }

    public static void main(String[] args) {
        CircularLL d=new CircularLL();

        d.addAtLast("1");
        d.addAtLast("2");
        d.addAtLast("3");
        d.addAtLast("4");
        d.addAtLast("5");
        d.displayStart();
        d.deleteElement("4");
        d.displayEnd();
        System.out.println("Length:" +d.length());

    }
}
