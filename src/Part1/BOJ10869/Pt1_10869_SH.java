package Part1.BOJ10869;

import java.io.*;
import java.util.StringTokenizer;

public class Pt1_10869_SH {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bw.write((A + B) + "\n");
        bw.write((A - B) + "\n");
        bw.write((A * B) + "\n");
        bw.write((A / B) + "\n");
        bw.write((A % B) + "\n");

        bw.flush();

        bw.close();
        br.close();
    }
}

/**
 *
 * 밑에 Scanner를 사용해서 문제를 풀고 그날 저녁..
 * BufferReader, BufferWriter를 사용해서 쓰니 메모리도 적게 들고 시간도 적게 들었다
 * 처음 써보는거라 write함수를 쓸 때 이것저것 해맸다...
 * write함수에서 개행문자를 쓰지 않으니 아무것도 출력이 되지않았다..
 * 찾아보니 buffer는 String 타입으로 출력하고 입력받아 생긴 문제였던듯..
 * Int형으로 출력할려면 끝에 개행문자나 공백을 입력해야하더라
 *
 * 이렇게 난 오늘도 성장하였다..ㅎ
 * 2024.01.29 (SUN)
 *
 * -------------------------------------------
 * 유빙빙님의 코드를 보니 다르게 했던데...
 * 속도 관련때문에 그런거 같던데...
 * 그 부분을 공부해서 그렇게도 새로 해봐야겠다
 * 쉬운 문제였지만
 * 그래도 맞아서
 * 기분은 짱짱굿 매애애애애앤~~~
 *
 * --------------------------------------------
 *
 * Scanner sc = new Scanner(System.in);
 *         int A = sc.nextInt();
 *         int B = sc.nextInt();
 *
 *         System.out.printf("%d\n", A+B);
 *         System.out.printf("%d\n", A-B);
 *         System.out.printf("%d\n", A*B);
 *         System.out.printf("%d\n", A/B);
 *         System.out.printf("%d\n", A%B);
 */
