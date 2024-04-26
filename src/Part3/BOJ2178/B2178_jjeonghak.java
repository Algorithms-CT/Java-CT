package Part3.BOJ2178;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class B2178_jjeonghak {

	private static int n, m;
	private static int[][] map;
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n + 1][m + 1];

		for (int i = 0; i < n; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i + 1][j + 1] = chars[j] - '0';
			}
		}
		sb.append(bfs());
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int bfs() {
		int result = 0;
		Queue<Tuple> q = new LinkedList<>();
		q.offer(new Tuple(1, 1, 1));
		while (!q.isEmpty()) {
			Tuple tuple = q.poll();
			if (tuple.x == n && tuple.y == m) {
				result = tuple.distance;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = tuple.x + dx[i];
				int ny = tuple.y + dy[i];

				if (nx > 0 && nx <= n && ny > 0 && ny <= m && map[nx][ny] == 1) {
					map[nx][ny] = 2;
					q.offer(new Tuple(nx, ny, tuple.distance + 1));
				}
			}
		}
		return result;
	}

	private static class Tuple {
		private int x;
		private int y;
		private int distance;

		private Tuple(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}

}
