package Part4.BOJ11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11053_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        int max =0;
        StringTokenizer stt = new StringTokenizer(br.readLine());

        for(int i=1;i < arr.length;i++){
            arr[i] = Integer.parseInt(stt.nextToken());
            dp[i] =1;           // 길이의 최소값 1로 모두 채워준다.
        }

        for(int i=1;i<arr.length;i++){
            for(int j=1;j<i;j++){
                if(arr[i]>arr[j]){              // 그전의 값들이 현재 볼 값 보다 작으면 해당하는 값중 길이가 가장 긴 값에 +1 해준다.
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);          // 가장 큰 길이 반환
        }
        System.out.println(max);
    }
}

/**
 * https://propercoding.tistory.com/42
 */
