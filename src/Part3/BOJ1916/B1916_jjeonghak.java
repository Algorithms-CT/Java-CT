package Part3.BOJ1916;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class B1916_jjeonghak {

	private static int n, m, start, end;
	private static final Map<Integer, List<Tuple>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			map.get(Integer.parseInt(input[0])).add(new Tuple(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
		}

		String[] input = br.readLine().split(" ");
		start = Integer.parseInt(input[0]);
		end = Integer.parseInt(input[1]);
		sb.append(solution());

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int solution() {
		int[] path = new int[n + 1];
		Arrays.fill(path, Integer.MAX_VALUE);

		PriorityQueue<Tuple> q = new PriorityQueue<>();
		q.offer(new Tuple(start, 0));

		while (!q.isEmpty()) {
			Tuple current = q.poll();
			int index = current.index;
			int distance = current.distance;

			if (distance >= path[index]) {
				continue;
			}
			path[index] = distance;

			for (Tuple next : map.get(index)) {
				if (distance + next.distance < path[next.index]) {
					q.offer(new Tuple(next.index, distance + next.distance));
				}
			}
		}
		return path[end];
	}

	private static class Tuple implements Comparable<Tuple> {
		private int index;
		private int distance;

		private Tuple(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Tuple o) {
			return Integer.compare(this.distance, o.distance);
		}
	}

}
