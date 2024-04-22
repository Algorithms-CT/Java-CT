package Part3.BOJ7569;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class B7569_jjeonghak {

	private static int m, n, h, cnt;
	private static int[][][] map;
	private static final Queue<Node> q = new LinkedList<>();
	private static final int[] dx = { 0, -1, 0, 1, 0, 0 };
	private static final int[] dy = { -1, 0, 1, 0, 0, 0 };
	private static final int[] dz = { 0, 0, 0, 0, -1, 1 };


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		m = Integer.parseInt(input[0]);
		n = Integer.parseInt(input[1]);
		h = Integer.parseInt(input[2]);
		map = new int[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				input = br.readLine().split(" ");
				for (int k = 0; k < m; k++) {
					map[i][j][k] = Integer.parseInt(input[k]);
					if (map[i][j][k] == 1) {
						q.offer(new Node(i, j, k));
					} else if (map[i][j][k] == 0) {
						cnt++;
					}
				}
			}
		}

		sb.append(solution());
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int solution() {
		int result = 0;
		while (!q.isEmpty()) {
			Node current = q.poll();
			result = Math.max(result, current.day);

			for (int i = 0; i < 6; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				int nz = current.z + dz[i];

				if (nx >= 0 && nx < m && ny >= 0 && ny < n && nz >= 0 && nz < h && map[nz][ny][nx] == 0) {
					map[nz][ny][nx] = 1;
					cnt--;
					q.offer(new Node(nz, ny, nx, current.day + 1));
				}
			}
		}
		if (cnt != 0) {
			return -1;
		}
		return result;
	}

	private static class Node {
		private int z;
		private int y;
		private int x;
		private int day;

		private Node(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.day = 0;
		}

		private Node(int z, int y, int x, int day) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.day = day;
		}
	}

}
