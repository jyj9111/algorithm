package codeup;

import java.util.Scanner;

public class Codeup1671 {
     String play(int user, int computer) {
        if(user == 0 && computer == 1) {
            return "win";
        } else if (user == 1 && computer == 2) {
            return "win";
        } else if (user == 2 && computer == 0) {
            return "win";
        } else if (user == computer) {
            return "tie";
        } else {
            return "lose";
        }

    }
    public static void main(String[] args) {
        Codeup1671 cd = new Codeup1671();
        Scanner sc = new Scanner(System.in);
        // 0바위 1가위 2보
        int user = sc.nextInt();
        int computer = sc.nextInt();
        System.out.println(cd.play(user, computer));
    }
}
