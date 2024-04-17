package Part3.BOJ2637;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class B2637_jjeonghak {

	private static int[] result, degree;
	private static int[][] path;
	private static final Map<Integer, List<Integer>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		result = new int[n + 1];
		degree = new int[n + 1];
		path = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			int z = Integer.parseInt(input[2]);
			map.get(x).add(y);
			path[x][y] = z;
			degree[y]++;
		}

		solution(n);

		for (int i = 1; i <= n; i++) {
			if (map.get(i).isEmpty()) {
				sb.append(i).append(" ").append(result[i]).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void solution(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		result[n] = 1;
		while (!q.isEmpty()) {
			int current = q.poll();
			List<Integer> list = map.get(current);

			for (int next : list) {
				result[next] += result[current] * path[current][next];

				if (--degree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}

}
