package Part4.BOJ1904;

import java.io.*;

public class B1904_jjeonghak {

	private static int n;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		sb.append(solution(n));

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int solution(int index) {
		if (index < 1) {
			return 0;
		} else if (index == 1) {
			return 1;
		} else if(index == 2) {
			return 2;
		} else if (dp[index] != 0) {
			return dp[index];
		}

		dp[index] = solution(index - 1) % 15746;
		dp[index] += solution(index - 2) % 15746;
		return dp[index] % 15746;
	}

}
