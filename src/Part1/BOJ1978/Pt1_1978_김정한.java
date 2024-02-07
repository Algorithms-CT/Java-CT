package Part1.BOJ1978;

import java.io.*;
import java.util.Arrays;

public class Pt1_1978_김정한 {

	private static boolean[] check = new boolean[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		init();
		int n = Integer.parseInt(br.readLine());
		long ans = Arrays.stream(br.readLine().split(" "))
				.map(Integer::parseInt)
				.filter(i -> !check[i])
				.count();
		sb.append(ans);

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void init() {
		check[0] = true;
		check[1] = true;

		for (int i = 2; i < Math.sqrt(1000); i++) {
			if (!check[i]) {
				for (int j = i * 2; j <= 1000; j += i) {
					check[j] = true;
				}
			}
		}
	}

}
