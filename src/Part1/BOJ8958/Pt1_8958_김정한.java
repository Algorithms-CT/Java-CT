package Part1.BOJ8958;

import java.io.*;
import java.util.Arrays;

public class Pt1_8958_김정한 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int ans = Arrays.stream(br.readLine().split("X"))
					.filter(s -> !s.isBlank())
					.map(String::length)
					.map(l -> sigma(l))
					.reduce(0, Integer::sum);
			sb.append(ans).append("\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int sigma(int n) {
		return n * (n + 1) / 2;
	}

}
