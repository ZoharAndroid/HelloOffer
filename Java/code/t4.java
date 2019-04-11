package Java.code;

import java.util.Scanner;

public class t4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(1==1) {
            int n = sc.nextInt();
            if(n==0) {
                break;
            }
            String sf = sc.next();
            String sm = sc.next();
            String sf1;
            String sf2;
            System.out.println(sf);
            System.out.println(sm);
            char[] af = new char[n];
            char[] am = new char[n];

            af = sf.toCharArray();
            am = sm.toCharArray();

            sf1 = String.valueOf(af);
            sf2 = String.valueOf(am);
            System.out.println(sf1);
            System.out.println(sf2);
            for (int i = 0; i < af.length; i++) {
                System.out.print(af+" ");
            }
            System.out.println();
            for (int i = 0; i < am.length; i++) {
                System.out.print(am+" ");
            }
        }
    }
}

