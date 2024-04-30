package Part4.BOJ2098;

import java.io.*;

public class B2098_jjeonghak {

	private static final int MAX = 17_000_000;
	private static int n, flag;
	private static int[][] dp, map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][1 << n];
		flag = (1 << n) - 1;

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		sb.append(solution(1, 0));

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int solution(int status, int index) {
		if (status == flag) {
			return map[index][0] == 0 ? MAX : map[index][0];
		} else if (dp[index][status] != 0) {
			return dp[index][status];
		}

		int f = 1;
		dp[index][status] = MAX;
		for (int next = 0; next < n; next++) {
			if (map[index][next] != 0 && (status & f) == 0) {
				dp[index][status] = Math.min(dp[index][status], solution(status | f, next) + map[index][next]);
			}
			f <<= 1;
		}

		return dp[index][status];
	}

}
