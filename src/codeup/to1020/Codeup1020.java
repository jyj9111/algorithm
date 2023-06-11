package codeup.to1020;

import java.util.Scanner;

public class Codeup1020 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        .split() 사용 버전
//        String[] split = sc.nextLine().split("-");
//        System.out.println(split[0]+split[1]);

        //String.substring() 사용 버전
        String numID = sc.nextLine();
        System.out.println(numID.substring(0,6) + numID.substring(7,14));
    }
}
