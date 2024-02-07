package Part1.BOJ10869;

import java.util.Scanner;

public class Pt1_10869_JH {

    public static void main(String args[]) {
        Integer A, B;

        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();

        System.out.println(A+B);
        System.out.println(A-B);
        System.out.println(A*B);
        System.out.println(A/B);
        System.out.println(A%B);
    }
}

/**
 * 1. Variable type
 * - primitive type : byte, short, int, long, double, float, char, boolean
 * - reference type : array, enum, class, interface
 *
 * 2. String to Number
 * - Byte.parseByte()
 * - Short.parseShort()
 * - Integer.parseInt()
 * - Long.parseLong()
 * - Float.parseFloat()
 * - Double.parseDouble()
 * - Boolean.parseBoolean()
 *
 * 3. Number to String
 * - String.valueOf()
 *
 * 4. Scanner
 * - Scanner in = new Scanner(System.in);
 * - System.in : reading byte code
 * - in.nextByte() / in.nextShort() / in.nextInt() / in.nextLong() / in.nextLong() / in.nextFloat() / in.nextDouble() / in.nextBoolean()
 * - in.next() / in.nextLine()
 *
 */
