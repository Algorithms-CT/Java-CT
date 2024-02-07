package Part1.BOJ10871;

import java.util.Scanner;

public class Pt1_10871_JH {

    public static int N, X;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        N = sc.nextInt();
        X = sc.nextInt();

        for(int i=0; i<N; ++i) {
            int tmp ; tmp = sc.nextInt();
            if(tmp < X) {
                System.out.print(tmp+ " ");
            }
        }
    }
}

/**
 * Array
 * - reference type
 * - created in heap memory (call by reference)
 *
 * Array initialization
 * - int[] arr / int arr[] / int arr[][] ...
 * - initialized as null
 *
 * Array assignment
 * - int[] arr / int arr[]
 *  - literal (need to be assigned as it's initialized) : int[] arr = {1, 2, 3 ...};
 *  - instance with literal                             : int[] arr = new int[] {1, 2, 3 ...};
 *  - instance with length                              : int[] arr = new int[3];
 * - int[][] arr / int arr[][]
 *  - literal (need to be assigned as it's initialized) : int[][] arr = {{1, 2, 3 ...}, {1, 2, 3 ...}}
 *  - instance with literal                             : int[][] arr = new int[][] {{1, 2, 3}, {4, 5, 6}}
 *  - instance with length                              : int[][] arr = new int[3][];
 *  - instance with length                              : int[][] arr = new int[3][4];
 *
 * Java as an Compiler and Interpreter
 * - Array, enum, Class, Interface 는 객체
 * - 객체들은 heap 영역에 생성
 * - heap 영역은 런타임에 생성됨
 * - 따라서 "arr = new int[N];" 부분에서 arr의 크기가 N의 입력 값에 따라서 동적으로 결정될 수 있음
 * - Java는 컴파일러, 인터프리터를 모두 사용
 *  - Java 코드 -> 바이트 코드 -> JVM에 의해 실행됨
 *  - 바이트 코드 실행 때 JVM은 인터프리터 방식을 사용
 *  - 단, JIT Compiler가 자주 사용되는 바이트 코드 부분을 기계어로 바꾸어 더 빠르게 실행
 */