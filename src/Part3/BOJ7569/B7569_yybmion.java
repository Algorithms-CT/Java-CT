package Part3.BOJ7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569_yybmion {
    static class Location{              // 3차원
        int x;
        int y;
        int z;

        public Location(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int N,M,H;
    static int tomato[][][];
    static int dx[] = {0, 0, -1, 1, 0, 0};          // x,y,z 의 토마토를 확인하려면 6개 필요
    static int dy[] = {0, 0, 0, 0, 1, -1};
    static int dz[] = {1, -1, 0, 0, 0, 0};
    static Queue<Location> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stt = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stt.nextToken());
        N = Integer.parseInt(stt.nextToken());
        H = Integer.parseInt(stt.nextToken());

        tomato = new int[H][N][M];              // 주의할점은 H가 첫번째 N 두번째 M 첫번째
        queue = new LinkedList<>();


        for(int h=0;h<H;h++){
            for(int i=0;i<N;i++){
                stt = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    tomato[h][i][j] = Integer.parseInt(stt.nextToken());        // 초기화 및 값 삽입
                    if(tomato[h][i][j]==1) queue.add(new Location(j,i,h));      // 큐에 익은것만 넣어준다. 익은거 poll해서 위아래,동서남북 확인해야함
                }
            }
        }

        if(queue.size() == M*N*H){          // 애초에 다 1이면 0출력
            System.out.println(0);
            return;
        }

        bfs();

    }

    static void bfs(){
        while(!queue.isEmpty()){
            Location poll = queue.poll();

            for(int i=0;i<6;i++){               // 익은 사과 꺼내서 위,아래,동서남북 모두 확인해서
                int nx = poll.x+dx[i];
                int ny = poll.y+dy[i];
                int nz = poll.z+dz[i];

                if(nx<0||nx>=M||ny<0||ny>=N||nz<0||nz>=H){
                    continue;
                }
                if(tomato[nz][ny][nx]==0){                          // 그것이 0,즉 안익었으면 사과가 인접해있으니 익게 될것이다.
                    tomato[nz][ny][nx] = tomato[poll.z][poll.y][poll.x] +1;         // 이게 중요한데 우리는 모든 사과가 다 익었을때의 최소 일수를 구해줘야한다.
                    queue.add(new Location(nx,ny,nz));                              // count를 따로 할 필요없이 1 부분을 기준으로 점점 인접한 부분(익을 부분)을 현재 익은 부분에서 +1 해준다.
                }                                                                   // 나중에 익는 부분은 점점 값이 커질것이다. 상상이 되는가?
            }
        }

        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(tomato[i][j][k]==0){  // 아직 익지않으면 말 안됨
                        System.out.println(-1);
                        return;
                    }
                    if(max < tomato[i][j][k]){      // 모든 배열 수 확인해서 제일 높은 숫자가 있는 곳이 모든 토마토가 익은 최소일이다.
                        max = tomato[i][j][k];
                    }
                }
            }
        }

        System.out.println(max-1);
    }
}
