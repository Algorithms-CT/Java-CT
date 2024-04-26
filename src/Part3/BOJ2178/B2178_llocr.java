package Part3.BOJ2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_llocr {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static int[][] miro;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++) {
            String s = br.readLine();
            for(int j = 0; j<m; j++) {
                miro[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }

        BFS(0,0);
        System.out.println(miro[n-1][m-1]);
    }

    private static void BFS(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i = 0; i<4; i++) { //상하좌우 탐색
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(x >= 0 && y >= 0 && x < n && y < m) {        //배열을 넘어가면 안 됨
                    if(miro[x][y] != 0 && !visited[x][y]) {     //0이어서 갈 수 없거나, 방문했던 곳이면 안 됨
                        visited[x][y] = true;                   //방문 가능한 곳
                        miro[x][y] = miro[now[0]][now[1]] + 1;  //깊이를 넣어 주기
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
