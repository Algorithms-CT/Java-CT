package Part4.BOJ9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9251_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        int[][] dp = new int[second.length() + 1][first.length() + 1];

        for(int i = 0; i<second.length(); i++) {
            char c = second.charAt(i);

            for(int j = 0; j<first.length(); j++) {
                if(c == first.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        System.out.println(dp[second.length()][first.length()]);

    }
}

/*
* LCS가... 무엇일까... 😅
* 참고 : https://twinw.tistory.com/126
*
* */