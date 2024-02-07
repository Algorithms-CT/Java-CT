package Part1.BOJ8958;

import java.util.Scanner;

public class Pt1_8958_JH {

    public static int N;
    public static int DP[] = new int[82];

    public static Scanner sc = new Scanner(System.in);

    static {
        DP[0] = 0;
        DP[1] = 1;
    }

    public static int getNSum (int idx) {
        if(idx < 1) return 0;
        if(DP[idx] == 0) return DP[idx] = idx + getNSum(idx-1);
        else return DP[idx];
    }

    public static boolean isCorrect(char[] str, int idx) {
        return str[idx] == 'O';
    }

    public static void main(String[] args) {
        N = Integer.parseInt(sc.nextLine());
        for(int i=0; i<N; ++i) {
            String TCInString;
            char[] TCInChar;

            TCInString = sc.nextLine();
            TCInChar = TCInString.toCharArray();

            int accumulatedCorrect = 0;
            int answer = 0;

            for(int j=0; j< TCInChar.length; ++j) {
                if(isCorrect(TCInChar, j)) accumulatedCorrect += 1;
                else {
                    answer += getNSum(accumulatedCorrect);
                    accumulatedCorrect = 0;
                }
            }
            answer += getNSum(accumulatedCorrect);

            System.out.println(answer);
        }
    }

}

/**
 * UTF-16 / Code Unit / Code Point
 * - UTF-16
 *      - UTF-16이란, "UNICODE 에 존재하는 문자집합" <-> "컴퓨터가 이해할 수 있는 0과 1" 로 상호 변환 위한 인코딩 / 디코딩 방식
 *      - 기본적으로 컴퓨터는 "문자 집합"에 속한 단어들만 다룰 수 있다. (ASCII, EUR-KR, UNICODE 등에 존재하는 문자들)
 *      - 인코딩이란, "문자 집합" 내의 문자 -> 0과 1로 "컴퓨터가 이해할 수 있는 코드" 로 변환
 *      - 디코딩이란, 0과 1로 "컴퓨터가 이해할 수 있는 코드" -> "문자 집합" 내의 문자 로 변환
 * - Code Unit
 *      - 각 문자를 표현(대표)하기 위해 사용되는 기본단위
 *      - 1 Code Unit = 16(b) bit = 2(B) Byte
 *      - 각 문자들은 1개나, 2개의 Code Unit 으로 인코딩된다
 *      - (예1) Z = 007A (16진수)
 *      - (예2) 水 = 6C34 (16진수)
 *      - (예3) 𝄞 = D834 DD1E (16진수)
 * - Code Point
 *      - 각 문자가 갖는 고유한 값
 *      - (예1) Z = 90 (10진수)
 *      - (예2) 水 = 27700 (10진수)
 *      - (예3) 𝄞 = 119070 (10진수)
 * - UTF-16 에서의 문자 표현 방식
 *      - 일반적인 문자들은 1 Code Unit 으로 표현된다
 *      - 하지만 보조문자(Supplementary Characters)들은 2 Code Unit 으로 표현된다
 *
 * String 에서의 문자 추출 방식
 * - Java는 UTF-16 방식의 인코딩 방식을 사용한다.
 * - (1) 따라서 String에서 직접 Char를 뽑아내려 시도할 경우 Code Unit, Code Point를 고려한 문자 추출이 필요하다
 *
 *      for (int i = 0; i < str.length(); ) {
 *          int codePoint = str.codePointAt(i);
 *          System.out.println("Code Point at index " + i + ": " + codePoint);
 *
 *          // Supplementary Character의 경우, 한 번에 2개의 코드 유닛을 건너뜁니다.
 *          if (Character.isSupplementaryCodePoint(codePoint)) {
 *              i += Character.charCount(codePoint);
 *          } else {
 *              i++;
 *          }
 *      }
 *
 * - (2) 그렇지 않다면 String.toCharArray() 사용 가능
 *
 *      String str = ...
 *      char ch = str.toCharArray()
 *
 * 풀이
 * - 0 갯수만 센 다음에 DP 쓰면 중복된 연산을 줄일 수 있지 않을까 싶어서 그냥 써봄
 */