package Part4.BOJ1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1904_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] answer = new long[n+2];

        if (n == 1) {
            System.out.println(1);
        } else if(n == 2) {
            System.out.println(2);
        } else {
            answer[1] = 1;
            answer[2] = 2;

            for(int i = 3; i<=n; i++) {
                answer[i] = (answer[i-1] + answer[i-2]) % 15746;
            }

            System.out.println(answer[n]);
        }
    }
}

/*
* 일단 잘 모르겠어서 1부터 5~6정도까지 몇 개의 수가 나올 수 있는지 확인해보았다
* 확인해보니, 피보나치와 비슷하게 n의 개수는 n-1의 개수 + n-2의 개수 였다!
* 이걸로 문제를 풀어야겠다! 생각하고, 앞에서 풀었던 2748번과 비슷하게 문제를 해결했다
* */
