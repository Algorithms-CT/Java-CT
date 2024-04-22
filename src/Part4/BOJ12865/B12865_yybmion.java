package Part4.BOJ12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt;

        stt = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stt.nextToken());
        int K = Integer.parseInt(stt.nextToken());

        int[][] dp = new int[N+1][K+1];
        int[] weight = new int[N+1];
        int[] price = new int[N+1];

        for(int i=1;i<=N;i++){
            stt = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(stt.nextToken());
            price[i] = Integer.parseInt(stt.nextToken());
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++){
                if(weight[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+price[i]);   // 점화식.... 생각하기 빡세다.
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}

/**
 * 냅색 알고리즘 문제다.
 * 풀이를 보면 항상 앞으로 이렇게 생각하며 풀어야지 하면서도 다른 dp 문제를 보면 점화식이 정말 떠오르지 않는다.
 * dp테이블을 항상 설계하는데 그 안에 들어가는 값들,  dp에 담아야 하는 내용은 언제나 답이 포함되어있어야 한다. (중요!)
 * https://code-lab1.tistory.com/74
 */



