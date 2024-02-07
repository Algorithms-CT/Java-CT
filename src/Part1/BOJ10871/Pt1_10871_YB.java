package Part1.BOJ10871;

import java.io.*;
import java.util.StringTokenizer;

public class Pt1_10871_YB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i < N ; i++){
            int res = Integer.parseInt(st2.nextToken());

            if(res < M) bw.write(res + " ");
        }

        bw.flush();
    }
}


/**
 * 처음에 BufferedReader로 입력을 어떻게 받아야하나 고민했다.
 * 예제 입력은 다음과 같았다.
 * 10 5
 * 1 10 4 9 2 3 8 5 7 6
 *
 * 그래서 일단 StringTokenizer는 아무런 뒤에 파라미터를 주지 않으면
 * 공백 단위로 자른다.
 * br.readline으로 한줄 읽어와서 nextToken으로 하나하나 요소들을 가져온다.
 */


/**
 * conlict test ++
 */
