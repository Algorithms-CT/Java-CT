package Part1.BOJ2588;

import java.io.*;

public class Pt1_2588_SH {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int first = Integer.parseInt(br.readLine());
        String second = br.readLine();

        char[] tmp = second.toCharArray();

        bw.write((first * (tmp[2] - '0'))  + "\n");
        bw.write((first * (tmp[1] - '0')) + "\n");
        bw.write((first * (tmp[0] - '0')) + "\n");
        bw.write((first * Integer.parseInt(second)) + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}

/**
 *
 * 다음날이 밝았네요
 * ㅎㅎ
 * 훨씬 간단해졌군요
 * 코드 길이는 줄었지만 시간은 조금 더 늘어났고 메모리는 비슷비슷하네요
 * 문자열을 가지고 하는 것보단 단순 연산하는게 더 효율이 좋다곤 합디다
 *
 * 단순히 문제를 해결하는것보다 성능도 같이 고려해봐야 하지만,,,
 * 일단..
 * 문제 해결이 익숙해질때쯤 성능도 차차 고려해보는것도
 * 괜찮을 거 같기도 하고
 * 고민을 좀 해보는걸로...
 * 2024.01.29 (MON)
 *
 * -----------------------------------
 *
 * Hmm....
 * 이게 최선인가...
 * 3자리 숫자를 저렇게 나누는 것 말고
 * 더 간단한 방법은... 없을까나..?!?!?!?!?
 * 알고 싶을 땐..! 구글링이닷!! 히히
 * 갔다 오겠슴다
 * .
 * .
 * .
 * 홀리 쉐에에에에에에ㅔ에에엣
 * 홀리몰리 과카몰리!!!!
 * 스트링으로 받아서 charAt이라는 함수를 사용하면 훨씬 간단해진다!!!!!!
 * 이렇게 또 하나를 알아가는군!!
 * 조아써!!!!
 * 하지만 오늘은 시간이 많이 늦었으니... 내일 도전해본다 흐흐
 *
 * -----------------------------------------------------------------
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *
 *         int first = Integer.parseInt(br.readLine());
 *         int second = Integer.parseInt(br.readLine());
 *
 *         int hund = second / 100;
 *         int ten = (second - hund*100) / 10;
 *         int one = second - hund*100 - ten*10;
 *
 *         bw.write(first * one + "\n");
 *         bw.write(first * ten + "\n");
 *         bw.write(first * hund + "\n");
 *         bw.write(((first * one) + (first * ten)*10 + (first * hund)*100) + "\n");
 *
 *         bw.flush();
 *         bw.close();
 *         br.close();
 *
 */
