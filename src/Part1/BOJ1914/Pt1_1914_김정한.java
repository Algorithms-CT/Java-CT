package Part1.BOJ1914;

import java.io.*;
import java.math.BigInteger;

public class Pt1_1914_김정한 {

	private static final int TOTAL = 6;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		BigInteger ans = BigInteger.TWO.pow(n).subtract(BigInteger.ONE);
		sb.append(ans).append("\n");
		if (n < 21) {
			hanoi(n, 1, 3);
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void hanoi(int index, int from, int to) {
		if (index == 1) {
			move(from, to);
			return;
		}

		int via = TOTAL - from - to;
		hanoi(index - 1, from, via);
		move(from, to);
		hanoi(index - 1, via, to);
	}

	private static void move(int from, int to) {
		sb
			.append(from).append(" ")
			.append(to).append("\n");
	}

}

/**
 * an = 2 * an-1 + 1
 * an = 2^n - 1
 *
 * must be used BigInteger
 *
 * input: 100
 * output: 1267650600228229401496703205375
 */
