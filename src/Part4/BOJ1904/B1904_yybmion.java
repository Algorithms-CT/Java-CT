package Part4.BOJ1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1904_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N+2];     // N+2 로 해야함, 아니면 N=1에서 인덱스 에러남

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        if(N>2) {
            for (int i = 3; i < arr.length; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
            }
        }

        System.out.println(arr[N]);
    }
}

/**
 * https://sskl660.tistory.com/87
 * https://wellohorld.tistory.com/17   // 코드는 틀림  , 개념만 보자
 */
