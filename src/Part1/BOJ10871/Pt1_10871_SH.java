package Part1.BOJ10871;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Pt1_10871_SH {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < size; i++){
            if(list.get(i) < num){
                bw.write(list.get(i) + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

/**
 * 첫째 줄에 입력을 수열 길이(size)랑 비교할 문자(num)를 입력하고
 * 다음 줄에 수열을 입력해야하는데
 * 수열 입력도 안하고 왜 계속 에러나는지 고민한 나란 사람....
 * ㅋㅋㅋㅋㅋㅋ 그래도 나름 빨리 알아차려서 다행이다 헤헷
 * 딱히 고민은 크게 안하고 이렇게 풀었는데 다른 사람들은 어떻게 풀었는지 궁금..
 * 아직은 스터디에 사람이 많이 없으니 유빙빙님거부터 봐야겠따
 * 오
 * 배열에 저장안하고 저렇게 하는 방법도 있었구나
 * 저장안하고 바로 받아와서 비교하면 불필요한 메모리 사용도 줄고 코드도 간단해지고
 * 나도 다음번엔 저 아이디어도 고려해서 문제를 풀어봐야겠다
 */
