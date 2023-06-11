package Programmers;


import java.util.*;

public class PgmsTest {
    public static void main(String[] args) {
        List<Integer> t1 = new ArrayList<>();

        t1.add(1);
        t1.add(2);
        t1.add(3);
        t1.add(4);
        int n = -1;
        int idx = 0;
        for(int temp : t1) {
            if(idx == 2) n = temp;
            idx++;
        }
        idx = 0;
        for(int temp : t1) {
            if(idx == 3) n = temp;
            idx++;
        }
        System.out.println(n);
    }
}