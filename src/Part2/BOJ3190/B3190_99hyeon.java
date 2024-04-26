package Part2.BOJ3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3190_99hyeon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        //보드
        int[][] map = new int[N+1][N+1];

        //사과가 있는 위치는 1로 초기화
        for(int i = 0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            map[row][col] = 1;
        }

        int L = Integer.parseInt(br.readLine());

        //시간에 따라서 회전시킬 방향 queue 생성
        Queue<spin> spin = new LinkedList<>();
        for(int i = 0; i<L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            spin.offer(new spin(time, dir));
        }
        br.close();

        //0은 북, 1은 동, 2는 남, 3은 서 의미
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        //초기 (1, 1)에서 시작하고 동쪽을 보고 시작
        int row = 1;
        int col = 1;
        int time = 0;
        int dir = 1;
        Queue<Node> q  = new LinkedList<>();
        q.offer(new Node(row, col));
        map[row][col] = 2;  //뱀이 있는곳은 2로

        while(true){
            int dR = row + dr[dir];
            int dC = col + dc[dir];

            time++;

            if(dR<1||dC<1||dR>N||dC>N)  //벽에 부딪혀서 종료
                break;
            if(map[dR][dC] == 2)    //자기 자신과 부딪혀서 종료
                break;

            if(map[dR][dC] == 0){   //사과 없는곳 도착
                Node node = q.poll();
                map[node.row][node.col] = 0;    //몸통길이 줄음
            }
            if(!spin.isEmpty()) {
                if (time == spin.peek().time) { //회전할 시간
                    spin s = spin.poll();

                    if (s.dir.equals("L"))
                        dir = dir-1 < 0 ? 3 : dir-1;
                    if (s.dir.equals("D"))
                        dir = dir+1 > 3 ? 0 : dir+1;
                }
            }

            map[dR][dC] = 2;
            q.offer(new Node(dR, dC));
            row = dR;
            col = dC;
        }

        System.out.println(time);
    }
}
class spin{
    int time;
    String dir;

    spin(int time, String dir){
        this.time = time;
        this.dir = dir;
    }
}

class Node{
    int row, col;

    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}

/**
 * 참고를 너무 많이 한 문제..
 * 나중에 다시 한 번 풀어볼 문제
 */
