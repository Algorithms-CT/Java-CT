package Part1.BOJ2588;

import java.util.Scanner;

public class Pt1_2558_HS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int origin = B;
        int[] arr = new int[3];

        for(int i = 0; i<arr.length; i++) {
            arr[i] = B % 10;
            B /= 10;
            System.out.println(A * arr[i]);
        }

        System.out.println(A*origin);
    }
}

/* TODO : 24.02.05
문자열로 변환할까 했지만, 그냥 숫자로 해결해보자! 하고 배열 가져다 씀...
근데 이게 더 시간이 오래 걸리고 뭔가 돌아돌아서 문제를 해결한 느낌이랄까?
백준에서 보니, 그냥 숫자 그대로 해결하는 게 빠르게 해결되는 것 같아서
앞으로 문제 더 풀어보며 더 효율적인 방식을 익혀야겠다는 생각!
* */