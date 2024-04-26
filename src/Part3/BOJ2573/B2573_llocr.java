package Part3.BOJ2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2573_llocr {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n;
    static int m;
    static int year = 0;
    static int[][] iceBerg;
    static class Ice {
        int x;
        int y;

        public Ice(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        iceBerg = new int[n][m];

        //빙산 정보 넣기
        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++) {
                iceBerg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            int result = countIsland();

            if(result >= 2) {
                break;
            } else if (result == 0) {
                year = 0;
                break;
            }

            melt();
            year++;
        }

        System.out.println(year);
    }

    private static int countIsland() {
        boolean[][] visited = new boolean[n][m];

        int count = 0;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(!visited[i][j] && iceBerg[i][j] > 0) {
                    checkIce(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void checkIce(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for(int i = 0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >=0 && ny < m) {
                if(!visited[nx][ny] && iceBerg[nx][ny] > 0) {
                    checkIce(nx, ny, visited);
                }
            }
        }
    }

    private static void melt() {
        Queue<Ice> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(iceBerg[i][j] > 0) {
                    queue.add(new Ice(i,j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Ice ice = queue.poll();

            int sea = 0;

            for(int i = 0; i<4; i++) {
                int nx = ice.x + dx[i];
                int ny = ice.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[nx][ny] && iceBerg[nx][ny] == 0) {
                        sea++;
                    }
                }
            }

            if(iceBerg[ice.x][ice.y] - sea < 0) {
                iceBerg[ice.x][ice.y] = 0;
            } else {
                iceBerg[ice.x][ice.y] -= sea;
            }
        }
    }

}