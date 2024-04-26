package Part3.BOJ2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS
 */
public class B2178_yybmion {
    public static class Pair{       // 좌표
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1,1,0,0};       // 상하좌우 나타내기 위한 dx,dy
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    static Queue<Pair> queue;
    static int[][] leastRoad;           // 거리 계산 배열
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stt = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stt.nextToken());
        M = Integer.parseInt(stt.nextToken());

        queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        arr = new int[N][M];
        leastRoad = new int[N][M];

        for(int i=0;i<N;i++){                   // 2차원 배열 다 넣어줌
            String line = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = line.charAt(j)-'0';
            }
        }

        queue.add(new Pair(0,0));           // 처음 0,0에서 시작하니 넣어줌
        leastRoad[0][0] = 0;
        visited[0][0] = true;

        bfs(visited);
    }
    static void bfs(boolean[][] visited){


        while(!queue.isEmpty()){
            Pair poll = queue.poll();           // 맨 처음 0,0 꺼내주고

            for(int i=0;i<4;i++){               // 그 기준으로 상하좌우를 확인해주는데, 그 좌표가 nx,ny다.
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if(nx<0 || nx>=N || ny <0 || ny >= M) continue;         // nx,ny 배열에서 N,M보다 벗어나거나, 0이하면 continue;

                if(!visited[nx][ny] && arr[nx][ny]>0){                  // 그 외에 방문을 안하고, 해당 배열이 1이라면 길 이동할 수 있다는 의미
                    queue.add(new Pair(nx,ny));                         // 그래서 큐에 해당 x,y 좌표 넣어줌
                    visited[nx][ny] = true;                             // 방문처리

                    leastRoad[nx][ny] = leastRoad[poll.x][poll.y] + 1;  // 거리를 1씩 늘려간다. https://iseunghan.tistory.com/312
                }
            }
        }

        System.out.println(leastRoad[N-1][M-1]+1);
    }
}
