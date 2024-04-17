package Part3.BOJ18352;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class B18352_jjeonghak {

	private static int n, m, k, x;
	private static final Map<Integer, List<Integer>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		k = Integer.parseInt(input[2]);
		x = Integer.parseInt(input[3]);
		for (int i = 1; i <= n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			map.get(a).add(b);
		}
		List<Integer> result = solution();

		for (int i : result) {
			sb.append(i).append("\n");
		}
		if (result.isEmpty()) {
			sb.append(-1);
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static List<Integer> solution() {
		List<Integer> result = new ArrayList<>();
		int[] check = new int[n + 1];
		Arrays.fill(check, -1);
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		check[x] = 0;
		while (!q.isEmpty()) {
			int current = q.poll();
			List<Integer> list = map.get(current);

			for (int next : list) {
				if (check[next] == -1 && check[current] < k) {
					check[next] = check[current] + 1;
					q.offer(next);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (i == x) {
				continue;
			} else if (check[i] == k) {
				result.add(i);
			}
		}
		return result;
	}

}
