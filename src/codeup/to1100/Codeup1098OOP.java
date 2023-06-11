package codeup.to1100;

import java.util.Scanner;

public class Codeup1098OOP {
    private int[][] arr;

    public Codeup1098OOP(int wide, int height) {
        this.arr = new int[height][wide];
    }

    public void setBeam(int len, int dir, int x, int y) {
        for (int i = 0; i < len; i++) {
            if(dir == 0) { //가로
                arr[x - 1][y + i - 1] = 1;
            } else { //세로
                arr[x + i - 1][y - 1] = 1;
            }
        }
    }
    public void printArr() {
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr[i].length; j++) {
                System.out.print(this.arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wide = sc.nextInt();
        int height = sc.nextInt();
        Codeup1098OOP cd = new Codeup1098OOP(wide, height);

        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int len = sc.nextInt();
            int dir = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            cd.setBeam(len, dir, x, y);
        }
        cd.printArr();
        System.out.println();
    }
}
