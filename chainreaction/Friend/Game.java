import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static boolean win = false;

    public static void main(String[] args) {
        System.out.println("Enter the number of rows and coloums");
        int row = sc.nextInt();
        int coloum = sc.nextInt();

        System.out.println("Enter the number of players");
        int number = sc.nextInt();
        char[] playerList = new char[number];
        int highScore = row * coloum - 1;

        for (int i = 0; i < number; i++) {
            System.out.println("Enter the Player " + (i + 1) + " name");
            playerList[i] = sc.next().charAt(0);
        }

        int n = 0;
        Player[][] game = new Player[row][coloum];
        fill(game);
        print(game);

        Queue<Point> queue = new LinkedList<Point>();

        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (true) {
            System.out.println("Enter the Player " + playerList[n % number] + " point of x and y");
            int xPoint = sc.nextInt();
            int yPoint = sc.nextInt();
            if (isValidPoint(game, xPoint, yPoint) && (game[xPoint][yPoint].name == playerList[n % number] || game[xPoint][yPoint].name == '-')) {
                queue.add(new Point(xPoint, yPoint));
                while (!queue.isEmpty()) {
                    Point p = queue.poll();
                    if (checkCondition(game, p.xPoint, p.yPoint, playerList[n % number], highScore, playerList)) {
                        for (int[] d : direction) {

                            if (isValidPoint(game, d[0] + p.xPoint, d[1] + p.yPoint)) {
                                queue.add(new Point(d[0] + p.xPoint, d[1] + p.yPoint));
                            }
                        }
                    }
                    if (win) {
                        System.out.println("--------------------Game is End---------------------------------------");
                        return;
                    }
                }
                n++;
            } else {
                System.out.println("You entered the wrong point ,Enter the valid point");
            }

            print(game);
        }

    }

    public static boolean checkWin(Player[][] game, int highScore, char[] player) {
        int[] score = new int[player.length];
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j].name != '-') {
                    score[game[i][j].name - 'A']++;
                }
            }
        }
//        System.out.println(Arrays.toString(score));

        for (int i = 0; i < score.length; i++) {
            if (score[i] == highScore) {
                System.out.println("----------------- Player " + player[i] + " is win the game ---------------");
                return true;
            }
        }
        return false;
    }


    public static boolean isValidPoint(Player[][] game, int x, int y) {
        return x >= 0 && y >= 0 && x < game.length && y < game[0].length;
    }

    public static boolean checkCondition(Player[][] game, int x, int y, char name, int highScore, char[] playerList) {
        if ((x == 0 && y == 0) || (x == 0 && y == game[0].length - 1) || (x == game.length - 1 && y == 0) || (x == game.length - 1 && y == game[0].length - 1)) {
            if (game[x][y].count == 1) {
                if (checkWin(game, highScore, playerList)) {
                    win = true;
                }
                game[x][y].count = 0;
                game[x][y].name = '-';
                return true;
            } else {
                game[x][y].count += 1;
                game[x][y].name = name;
                return false;
            }
        } else if (x == 0 || y == game[0].length - 1 || x == game.length - 1 || y == 0) {
            if (game[x][y].count == 2) {
                if (checkWin(game, highScore, playerList)) {
                    win = true;
                }
                game[x][y].count = 0;
                game[x][y].name = '-';
                return true;
            } else {
                game[x][y].count += 1;
                game[x][y].name = name;
                return false;
            }
        } else if (game[x][y].count == 3) {
            if (checkWin(game, highScore, playerList)) {
                win = true;
            }
            game[x][y].count = 0;
            game[x][y].name = '-';
            return true;
        } else {
            game[x][y].count += 1;
            game[x][y].name = name;
            return false;
        }

    }

    public static void fill(Player[][] game) {

        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                game[i][j] = new Player();
            }
        }

    }

    public static void print(Player[][] game) {
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < game.length; i++) {
            for (Player p : game[i]) {
                System.out.print("  " + p + "  ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------------");
    }
}
