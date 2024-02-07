package Part1.BOJ2869;

import java.util.Scanner;

public class Pt1_2869_JH {

    public static int A, B, V;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        A = sc.nextInt();
        B = sc.nextInt();
        V = sc.nextInt();

        System.out.println((V-A)/(A-B) + ((V-A)%(A-B)==0 ? 1 : 2));

    }

}
