package Part1.BOJ2753;

import java.util.Scanner;

public class Pt1_2753_JH {

    public static Scanner sc = new Scanner(System.in);
    public static Integer year;

    public static boolean isMultipleOf_4(Integer num) {
        return num % 4 == 0;
    }

    public static boolean isMultipleOf_100(Integer num) {
        return num % 100 == 0;
    }

    public static boolean isMultipleOf_400(Integer num) {
        return num % 400 == 0;
    }

    public static void main(String[] args) {
        year = sc.nextInt();

        if(isMultipleOf_4(year) && (!isMultipleOf_100(year) || isMultipleOf_400(year))) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }

}
