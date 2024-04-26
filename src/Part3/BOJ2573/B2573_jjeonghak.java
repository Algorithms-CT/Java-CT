package Part3.BOJ2573;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B2573_jjeonghak {
// public class Main {

	private static int n, m;
	private static int[][] map;
	private static boolean[][] check;
	private static Queue<Tuple> current = new LinkedList<>();
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n][m];
		check = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] != 0) {
					current.add(new Tuple(i, j));
				}
			}
		}
		sb.append(solution());
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int solution() {
		int day = 0;
		while(!current.isEmpty()) {
			day++;
			Queue<Tuple> next = new LinkedList<>();
			initDay(next);
			current.addAll(next);
			if (isFinish(next)) {
				break;
			}
		}

		if (current.isEmpty()) {
			return 0;
		}
		return day;
	}

	private static void initDay(Queue<Tuple> next) {
		List<Tuple> sub = new ArrayList<>();
		while(!current.isEmpty()) {
			Tuple tuple = current.poll();
			int x = tuple.x;
			int y = tuple.y;

			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (map[nx][ny] == 0) {
						cnt++;
					}
				}
			}
			if (map[x][y] > cnt) {
				map[x][y] -= cnt;
				next.add(new Tuple(x, y));
			} else {
				sub.add(new Tuple(x, y));
			}
		}
		sub.forEach(t -> map[t.x][t.y] = 0);
	}

	private static boolean isFinish(Queue<Tuple> next) {
		if (next.isEmpty()) {
			return true;
		}

		Queue<Tuple> sub = new LinkedList<>();
		sub.add(next.peek());
		boolean flag = check[next.peek().x][next.peek().y];
		check[next.peek().x][next.peek().y] = !flag;
		int cnt = 0;
		while (!sub.isEmpty()) {
			Tuple tuple = sub.poll();
			int x = tuple.x;
			int y = tuple.y;
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (map[nx][ny] != 0 && check[nx][ny] == flag) {
						check[nx][ny] = !flag;
						sub.add(new Tuple(nx, ny));
					}
				}
			}
		}
		return next.size() != cnt;
	}

	private static class Tuple {
		private int x;
		private int y;

		public Tuple(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
