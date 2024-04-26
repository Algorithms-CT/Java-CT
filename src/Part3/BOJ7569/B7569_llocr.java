package Part3.BOJ7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569_llocr {
    static int[] dx = {0, 0, -1, 1, 0, 0};   //m (순서 : 상하좌우앞뒤)
    static int[] dy = {0, 0, 0, 0, -1, 1};   //n
    static int[] dz = {1, -1, 0, 0, 0, 0};   //h
    static int h, m, n;
    static int[][][] arr;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][n][m];
        visited = new boolean[h][n][m];

        for(int i = 0; i<h; i++) {
            for(int j = 0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) {
                        queue.add(new int[] {i,j, k});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        BFS();

        int answer = 0;

        for(int i = 0; i<h; i++) {
            for(int j = 0; j<n; j++) {
                for(int k = 0; k<m; k++) {
                    if(arr[i][j][k] == 0) {
                        answer = -1;
                        System.out.println(answer);
                        System.exit(0);

                    } else if (arr[i][j][k] > 0) {
                        answer = Math.max(answer, arr[i][j][k]);
                    }
                }
            }
        }

        System.out.println(answer - 1);
        // 익은 토마토가 1로 시작하기 때문에 익은 날짜가 모두 1씩 크다..!
    }

    private static void BFS() {

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i<6; i++) {
                int x = now[2] + dx[i];
                int y = now[1] + dy[i];
                int z = now[0] + dz[i];

                if(x >= 0 && y >= 0 && z >= 0 &&
                    x < m && y < n && z < h) {
                    if(!visited[z][y][x] && arr[z][y][x] != -1) {
                        visited[z][y][x] = true;
                        arr[z][y][x] = arr[now[0]][now[1]][now[2]] + 1; //익은 날짜 넣기
                        queue.add(new int[] {z, y, x});
                    }
                }
            }
        }
    }
}
