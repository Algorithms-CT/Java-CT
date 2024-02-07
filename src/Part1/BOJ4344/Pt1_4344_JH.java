package Part1.BOJ4344;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Pt1_4344_JH {

    public static int C, N, arr[];

    public static Scanner sc = new Scanner(System.in);
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        C = Integer.parseInt(sc.nextLine());

        for(int i=0; i<C; ++i) {
            st = new StringTokenizer(sc.nextLine(), " ");

            N = Integer.parseInt(st.nextToken());
            arr = new int[N];

            int sum=0;
            double avg=0.0;

            for(int j=0; j<N; ++j) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
                avg += arr[j];
            }

            avg = avg / N;

            int overAvgCnt=0;

            for(int j=0; j<N; ++j) {
                if(arr[j] > avg) overAvgCnt += 1;
            }

            System.out.printf("%.3f", (double)overAvgCnt * 100/N);
            System.out.println("%");

        }

    }

}

/**
 * Java I/O 분석
 *
 * 1) System.in (https:/®/docs.oracle.com/javase/8/docs/api/java/lang/System.html)
 *  - java.lang.Object <- java.lang.System
 *  - System 클래스에는 'in' 이라는 정적 필드가 존재함
 *  - in 필드 : static / InputStream 타입
 *      - stream 은 데이터가 출발지에서 도착지로 흘러간다는 의미이다
 *      - I/O 장치 -> 프로세스 : InputStream
 *      - 프로세스 -> I/O 장치 : OutputStream
 *
 *
 * 2) Scanner.in (https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/util/Scanner.html)
 *  - java.lang.Object <- java.util.Scanner
 *  - 생성자로 InputStream 타입을 인자로 받는다 (따라서, System.in 을 받을 수 있는 것)
 *  - 메서드들 ...
 *      - nextLine() : 마지막에 등장하는 Line Separator (\n,\r) 를 제외한 문장을 return 함. 그리고 다음 문장 위치부터 읽을 준비를 한다.
 *      - nextInt() : 다음 등장하는 int 형으로 인식가능한 token 을 return 함. 다음 위치부터 읽을 준비를 함.
 *
 *
 * 3) StringTokenizer
 *  - java.lang.Object <- java.util.StringTokenizer
 *  - 생성자로 String, delimiter 를 입력받는다.
 *  - nextToken 메서드를 활용하면 갯수만큼 불러들일 수 있다
 *
 *  for( ,,, ) {
 *      int val = Integer.parseInt(st.nextToken())
 *  }
 *
 *
 * 4) BufferedReader (https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html)
 *  - java.lang.Object <- java.io.Reader <- java.io.BufferedReader
 *  - 생성자로 Reader 타입을 인자로 받는다 (Reader <- InputStreamReader)
 *
 *    new BufferedReader(new InputStreamReader(System.in))
 *
 *  - 다음의 방식으로 쭉 읽어들일 수 있다
 *
 *    String str = "";
 *    String tmp = "";
 *    while((tmp=bf.readLine()) != null) {
 *      str += tmp + "\n";
 *    }
 *
 */