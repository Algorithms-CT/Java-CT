package Part1.BOJ2753;

import java.util.Scanner;

public class Pt1_2753_HS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if(year % 4 == 0) {
            if(year % 100 != 0 ||year % 400 == 0) {
                System.out.println(1);
            }
        } else {
            System.out.println(0);
        }
    }
}

/* TODO 24.02.05
증말 오랜만에 푸는 윤년문제
조건문 어떻게 하면 효율적으로 할 수 있을지..~ 더 공부해봐야겠꾼요
* */