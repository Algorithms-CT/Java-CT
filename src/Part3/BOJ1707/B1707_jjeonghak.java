package Part3.BOJ1707;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class B1707_jjeonghak {

	private static String result;
	private static int[] check;
	private static Map<Integer, List<Integer>> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			String[] input = br.readLine().split(" ");
			int v = Integer.parseInt(input[0]);
			int e = Integer.parseInt(input[1]);
			check = new int[v + 1];
			map = new HashMap<>();
			for (int j = 1; j <= v; j++) {
				map.put(j, new ArrayList<>());
			}
			for (int j = 0; j < e; j++) {
				input = br.readLine().split(" ");
				int n1 = Integer.parseInt(input[0]);
				int n2 = Integer.parseInt(input[1]);
				map.get(n1).add(n2);
				map.get(n2).add(n1);
			}
			result = "YES";
			for (int j = 1; j <= v; j++) {
				if (result.equals("YES") && check[j] == 0) {
					solution(j);
				}
			}
			sb.append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void solution(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = 1;
		while (!q.isEmpty()) {
			int index = q.poll();
			for (int next : map.get(index)) {
				if (check[next] == 0) {
					check[next] = check[index] == 1 ? 2 : 1;
					q.add(next);
				} else if (check[next] == check[index]) {
					result = "NO";
					return;
				}
			}
		}
	}

}
