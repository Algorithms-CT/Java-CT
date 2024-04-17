package Part4.BOJ11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11053_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; //모든 dp값은 최소 1
        }

        int max = 1;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //이전 원소들 중 가장 큰 dp값 + 1
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}

/*
* LIS가 뭔디... 이러고 이상한 코드 짰다가 "틀렸습니다" 보고 절망...
* 결국 알고리즘 참고했다 :(
* https://propercoding.tistory.com/41
* 나는 그냥 전의 값을 계속 업데이트 했는데, 이게 예제에서는 맞는 이야기일 수 있겠지만?
* 다른 예제에서는 전혀 맞지 않는 얘기였던 것 같다 쩝 ㅎㅎ
*
* 이전 코드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++) {
            if(arr[i-1] < arr[i]) {
                dp[i] = dp[i-1] + 1;
            } else if (arr[i-1] >= arr[i]) {
                arr[i] = arr[i-1];
                dp[i] = dp[i-1];
            }
        }

        System.out.println(dp[n]);
    }
* */