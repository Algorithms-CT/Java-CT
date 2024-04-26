package Part3.BOJ2252;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class B2252_jjeonghak {

	private static int n, m;
	private static int[] edge;
	private static final Map<Integer, List<Integer>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		edge = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int previous = Integer.parseInt(input[0]);
			int next = Integer.parseInt(input[1]);
			edge[next]++;
			map.get(previous).add(next);
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (edge[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int current = q.poll();
			sb.append(current).append(" ");

			for (int next : map.get(current)) {
				if (--edge[next] == 0) {
					q.offer(next);
				}
			}
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
