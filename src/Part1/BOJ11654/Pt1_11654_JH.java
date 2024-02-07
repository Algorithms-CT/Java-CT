package Part1.BOJ11654;

import java.util.Scanner;

public class Pt1_11654_JH {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(sc.nextLine().codePointAt(0));
    }

}

/**
 * 자동 타입 변환
 * : byte -> short(char) -> int -> long -> float -> double
 * : -> 방향으로 변수값 할당할 경우 타입변환이 자동적으로 일어난다.
 *
 * String -> char
 * (1) String.charAt(idx)
 *  : idx 위치의 code unit
 *  : char 반환
 * (2) String.codePointAt(idx)
 *  : idx 위치의 code point
 *  : int 반환
 * (3) String.length()
 *  : code unit 길이
 *  : int 반환
 * (4) String.codePointCount(s, e)
 *  : code point 길이
 *  : int 반환
 * (5) String.toCharArray()
 *  : char[] 배열 반환
 */