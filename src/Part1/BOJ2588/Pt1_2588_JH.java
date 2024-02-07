package Part1.BOJ2588;

import java.util.Scanner;

public class Pt1_2588_JH {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Integer A, B;

        A = sc.nextInt();
        B = sc.nextInt();

        System.out.println(A * (B % 10));
        System.out.println(A * (B % 100 / 10));
        System.out.println(A * (B / 100));
        System.out.println(A * B);

    }

}
