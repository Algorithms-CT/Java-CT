package Part4.BOJ9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9251_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();

        int[][] dp = new int[arr1.length+1][arr2.length+1];             // arrayindex ERROR 피하기 위해 0 부분은 제외하고 +1 길이로 만들어줌

        for(int i=1;i<=arr1.length;i++){
            for(int j=1;j<=arr2.length;j++){
                if(arr1[i-1]==arr2[j-1]){               // 같다면 대각선의 LCS에서 +1 해준다는 규칙을 발견
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);         // 만약 같지 않다면 바로 위 바로 왼쪽 값과 비교하여 큰 값을 넣어준다. 그 이유는 행부터 시작하나 열부터 시작하나 다 따져줘야하기 때문이다. 자세한 설명은 아래 링크에 나와있다.
                }
            }
        }

        System.out.println(dp[arr1.length][arr2.length]);
    }
}

/**
 * 여전히 규칙을 찾아 코드로 구현하기가 어렵다.
 * https://infodon.tistory.com/78
 * https://st-lab.tistory.com/139
 */
