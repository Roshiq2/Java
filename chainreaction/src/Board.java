import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Board {
    int[][] arr;
    public Board(int row,int col) {
        this.arr = new int[row][col];
    }

    void insert(int row, int col){
        arr[row][col]+=1;
        chainreact(row,col);
    }
    public List<List<Integer>> getNeighbor(int row, int col){
        int rows= arr.length;
        int cols=arr[0].length;
        ArrayList<List<Integer>> al=new ArrayList<>();
        if(row>0){
            al.add(List.of(row-1,col));
        }
        if(row<rows-1){
            al.add(List.of(row+1,col));
        }
        if(col>0){
            al.add(List.of(row,col-1));
        }
        if(col<cols-1){
            al.add(List.of(row,col+1));
        }
        return al;
    }
    void chainreact(int row, int col){
        while(true){
            if(arr[row][col]==2 && (row==0 || row ==4) && (col==0 || col==4) ){
                arr[row][col]=0;
                for(List<Integer>l:getNeighbor(row,col)){
                    insert(l.get(0),l.get(1));
                }
            }else if(arr[row][col]==3){
                arr[row][col]=0;
                for(List<Integer>l:getNeighbor(row,col)){
                    insert(l.get(0),l.get(1));
                }
            }else return;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Board b=new Board(5,5);
        while(true){
            b.printBoard();
            System.out.println("Row, Col: " );
            int r=sc.nextInt();
            int c=sc.nextInt();
            b.insert(r,c);
        }
    }

    private void printBoard() {
        for(int[] a:arr){
            System.out.println(Arrays.toString(a));
        }
    }
}

