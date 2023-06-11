package codeup.to1130;

import java.util.Scanner;

public class Codeup1124 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String data = sc.nextLine();

        int idxOfC = data.indexOf("C");
        int idxOfH = data.indexOf("H");

        int cWeight = Integer.parseInt(data.substring(idxOfC + 1, idxOfH));
        int hWeight = Integer.parseInt(data.substring(idxOfH + 1, data.length()));

        System.out.println(cWeight * 12 + hWeight);
    }
}
