import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


//탑다운 방식으로만 풀다가 바텀업으로도 풀고 싶어서 관련블로그를 찾아보며 공부를 하였다.
//https://st-lab.tistory.com/123
public class B2748_samgashyeong {

    static long[] memo = new long[101];
    static long f(int n){
        if(n==0 || n == 1){
            return n;
        }

        if(memo[n] == -123){
            memo[n] = f(n-2) + f(n-1);
        }

        return memo[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i=0;i<101;i++){
            memo[i] = -123;
        }

        memo[0] = 0;
        memo[1] = 1;
        int n = Integer.parseInt(br.readLine());
        System.out.println(f(n));
    }
}