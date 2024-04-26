package Part3.BOJ14888;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.function.BinaryOperator;

public class B14888_jjeonghak {

	private static int n;
	private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	private static int[] arr;
	private static final int[] operators = new int[4];
	private static final Map<Integer, BinaryOperator<Integer>> map = Map.of(
			0, (x, y) -> x + y,
			1, (x, y) -> x - y,
			2, (x, y) -> x * y,
			3, (x, y) -> x / y
	);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();


		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(input[i]);
		}
		bt(1, arr[0]);
		sb.append(max).append("\n").append(min);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void bt(int index, int total) {
		if (index == n) {
			max = Math.max(max, total);
			min = Math.min(min, total);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (operators[i] != 0) {
				operators[i]--;
				bt(index + 1, map.get(i).apply(total, arr[index]));
				operators[i]++;
			}
		}
	}

}
