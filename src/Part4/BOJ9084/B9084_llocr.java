package Part4.BOJ9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9084_llocr {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());

            int[] dp = new int[m + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (j - coins[i] > 0) {
                        dp[j] = dp[j] + dp[j - coins[i]];
                    } else if (j - coins[i] == 0) {
                        dp[j]++;
                    }
                }
            }

            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);
    }
}

/*
* dp[j] = dp[j] + dp[j - coins[i]];
* 이걸 이용할 수 있어야, 제대로 문제를 풀 수 있는 것 같다!
* 배열을 크게 만들지 않고, 한 배열에서 이전의 값들을 계속 활용하면서 가는 게 포인트인 것 같다
* 계속 푸는 방법들 익혀봐야겠다 :(
* */
