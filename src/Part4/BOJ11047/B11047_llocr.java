package Part4.BOJ11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());       //동전 개수
        int sum = Integer.parseInt(st.nextToken());     //만들어야 하는 동전 값

        int[] coin = new int[n];                         //동전들

        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        for(int i=n-1; i >= 0; i--) {
            if(coin[i] <= sum ) {           //동전이 만들어야 하는 동전 값보다 작거나 같다면
                result += sum / coin[i];    //만들어야 하는 값을 동전의 값으로 나눈 후 그 결과를 result에 +
                sum = sum % coin[i];        //남은 값은 만들어야 하는 값에서 동전 값으로 나눈 나머지
            }
        }

        System.out.println(result);
    }
}
