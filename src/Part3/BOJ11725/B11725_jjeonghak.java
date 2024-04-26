package Part3.BOJ11725;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class B11725_jjeonghak {

	private static int[] result;
	private static Map<Integer, List<Integer>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		result = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int i = 1; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int node1 = Integer.parseInt(input[0]);
			int node2 = Integer.parseInt(input[1]);
			map.get(node1).add(node2);
			map.get(node2).add(node1);
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		result[1] = 1;
		while (!q.isEmpty()) {
			Integer parent = q.poll();
			List<Integer> children = map.get(parent);

			for (int child : children) {
				if (result[child] == 0) {
					q.offer(child);
					result[child] = parent;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			sb.append(result[i]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
