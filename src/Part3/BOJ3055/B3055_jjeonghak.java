package Part3.BOJ3055;

import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class B3055_jjeonghak {

	private static final Map<Character, Integer> table = Map.of(
			'D', 3,
			'*', 1,
			'X', -1,
			'S', 2,
			'.', 0
	);
	private static final Queue<Node> q = new LinkedList<>();
	private static final int[] dx = { -1, 1, 0, 0 };
	private static final int[] dy = { 0, 0, -1, 1 };

	private static int n, m, sx, sy;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = table.get(chars[j]);
				if (map[i][j] == 1) {
					q.offer(new Node(i, j, 0, true));
				} else if (map[i][j] == 2) {
					sx = i;
					sy = j;
					map[i][j] = 4;
				}
			}
		}
		int result = solution();
		sb.append(result == -1 ? "KAKTUS" : result);

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int solution() {
		q.offer(new Node(sx, sy, 0, false));
		while (!q.isEmpty()) {
			Node current = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (map[nx][ny] == 0) {
						q.offer(new Node(nx, ny, current.distance + 1, current.isWater));
						if (!current.isWater) {
							map[nx][ny] = 4;
						} else {
							map[nx][ny] = 1;
						}
					} else if (map[nx][ny] == 4 && current.isWater) {
						q.offer(new Node(nx, ny, current.distance + 1, true));
						map[nx][ny] = 1;
					} else if (map[nx][ny] == 3 && !current.isWater) {
						return current.distance + 1;
					}
				}
			}
		}
		return -1;
	}

	private static class Node {
		private int x;
		private int y;
		private int distance;
		private boolean isWater;

		private Node(int x, int y, int distance, boolean isWater) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.isWater = isWater;
		}
	}

}
