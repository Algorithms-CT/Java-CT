package Part4.BOJ9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9084_yybmion {
    static int T,N,M;
    static int[] arr,dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stt;

        T = Integer.parseInt(br.readLine());

        while(T-->0) {
            N = Integer.parseInt(br.readLine());
            stt = new StringTokenizer(br.readLine());
            arr = new int[N+1];

            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(stt.nextToken());
            }

            M = Integer.parseInt(br.readLine());
            dp = new int[M+1];

            dp[0] = 1;  // j - a[i]=0 이되는 경우는 즉, m과 첫번째 동전의 금액이 같아지는 경우,
                        // 예를들면 2원으로 2원을 만드는 경우를 의미하기 때문에,
                        // 이 경우는 반드시 1번은 만들 수 있으므로 d[0]=1로 지정하였다.

            for(int i=0;i<N;i++){
                for(int j=arr[i];j<=M;j++){
                    dp[j] += dp[j-arr[i]];      // 전에 동전으로 세운 가지수를 그대로 가져와 더해준다. 아마 설명은 아래 링크를 보는 것을 추천한다.
                }
            }

            sb.append(dp[M]).append("\n");
        }

        System.out.println(sb);

    }

}

/**
 * https://d-cron.tistory.com/23
 * https://blog.naver.com/occidere/220793012348
 */
