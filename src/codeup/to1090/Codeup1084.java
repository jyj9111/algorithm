package codeup.to1090;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Codeup1084 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int red = sc.nextInt();
        int green = sc.nextInt();
        int blue = sc.nextInt();

        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < red; i++) {
            for (int j = 0; j < green; j++) {
                String temp = "";
                for (int k = 0; k < blue; k++) {
                    temp += i + " " + j + " " + k + "\n";
                }
                bf.write(temp);
                bf.flush();
            }
        }
        System.out.println(red * green * blue);
    }
}
