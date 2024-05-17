import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


///다른 dp문제들과 다르게 점화식을 빠르게 찾고 풀 수가 있었다. 참고로 배열의 크기를 n+1로 했을 때 99%에서 런타임 에러가 났다.
public class B1904_samgashyeong {
    static int[] dp;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+100];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%15746;
        }


        System.out.println(dp[n]);

    }
}
