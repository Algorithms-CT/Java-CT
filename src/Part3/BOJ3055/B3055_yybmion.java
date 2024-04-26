package Part3.BOJ3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 초기생각
 * 1. Queue를 S 고슴도치가 이동하는 큐 하나
 * 2. * 태풍이 퍼져나가는 큐 하나 만들어준다.
 * 3. 먼저 태풍이 번져나가고 이후 고슴도치가 이동한다.
 * 4. 고슴도치는 태풍인 자리를 지나가지 못한다.
 * 5. 거리를 계속해서 +1 해 나아가며 계산하고 visited를 이용해
 * 6. 어짜피 제일 먼저 visited채워지면 그게 최단거리이기 때문에 이후 visited체크된 곳에 들어와도
 * 7. 그것은 최단거리가 아닐 것이다.
 */
public class B3055_yybmion {
    static int R;      // 행
    static int C;       // 열
    static String[][] arr;      // 입력 값 받기
    static int[] dx = {-1,1,0,0};       // X,Y 좌표
    static int[] dy = {0,0,-1,1};
    static Queue<Node> rain;            // 태풍 큐
    static Queue<Node> animal;          // 고슴도치 큐
    static boolean[][] visited;         // 태풍 방문
    static boolean[][] ani;             // 고슴도치 방문
    static int[][] leastRoad;           // 최소 거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stt.nextToken());
        C = Integer.parseInt(stt.nextToken());

        arr = new String[R][C];
        visited = new boolean[R][C];
        ani = new boolean[R][C];
        rain = new LinkedList<>();
        animal = new LinkedList<>();
        leastRoad = new int[R][C];

        for(int i=0;i<R;i++){
            stt = new StringTokenizer(br.readLine());
            String check = stt.nextToken("");
            for(int j=0;j<C;j++){
                char c = check.charAt(j);
                if(c=='*'){                 // 태풍 시작 부분 먼저 태풍 큐에 넣어줌
                    rain.add(new Node(i,j));
                    visited[i][j] = true;       // 그리고 방문처리
                }
                else if(c=='S'){
                    animal.add(new Node(i,j));      // 고슴도치 시작 부분 또한 animal 큐에 넣어주고
                    visited[i][j] = true;           // 방문 처리
                    leastRoad[i][j] =0;             // 그곳은 0 부터 시작
                }
                String loc = Character.toString(c); // 이건 그냥 char을 String으로 바꾸려고 작성함
                arr[i][j] = loc;
            }
        }

        bfs();

    }
    static void bfs(){
        int nx=0;
        int ny=0;
        Node poll1;
        Node poll2;
        while(!animal.isEmpty()){
            int size1 = rain.size();        // 이거 본격적으로 rain큐와 animal큐 돌리기전에 사이즈 재는 이유가 태풍은 인접한 곳 다 물로 채워야해서
            int size2 = animal.size();       // 그러니까 고슴도치가 지나가기 전에 인접한 곳 다 물로 먼저 안채우면 오류가 생김
            while(size1-->0) {              // 그래서 이거 안하면 안됨 이해될거라 믿음
                poll2 = rain.poll();
                for (int i = 0; i < 4; i++) {       // 태풍의 앞,뒤,위,아래 확인
                    nx = poll2.x + dx[i];
                    ny = poll2.y + dy[i];

                    if (nx >= R || nx < 0 || ny >= C || ny < 0) continue;   //범위 넘으면 이어서

                    if (arr[nx][ny].equals("D") || arr[nx][ny].equals("X") || arr[nx][ny].equals("*")) continue; // 그 곳이 돌이거나 태풍이거나 도착지면 이어서 이 세부분은 물이 차면 안된다.

                    if(visited[nx][ny]) continue;    // 여기까지 오면 방문체크 방문하면 이어서

                        visited[nx][ny] = true;         // 이제 진짜 걸릴거 없으니 방문체크하고
                        arr[nx][ny] = "*";              // 물로 채워준다.
                        rain.add(new Node(nx, ny));     // 태풍 큐에 추가
                }
            }
            while(size2-->0) {
                poll1 = animal.poll();
                ani[poll1.x][poll1.y] = true;       // 현재 고슴도치 위치도 방문처리

                for (int i = 0; i < 4; i++) {
                    nx = poll1.x + dx[i];
                    ny = poll1.y + dy[i];

                    if (nx >= R || nx < 0 || ny >= C || ny < 0) continue;

                    if (arr[nx][ny].equals("*")) {          // 물이면 이어서
                        continue;
                    }
                    if (visited[nx][ny] || ani[nx][ny]) {       // 고슴도치가 지나간 자리이거나 물 방문이면 이어서
                        continue;
                    } else if (arr[nx][ny].equals("D")) {        // 여기서 도착 지점이라면
                        System.out.println(leastRoad[poll1.x][poll1.y] + 1);        // 바로 그 자리의 +1 을 return해줌
                        return;
                    }
                    if(arr[nx][ny].equals("X")){                // 돌도 패스
                        continue;
                    }
                    animal.add(new Node(nx, ny));               // animal 큐에 추가
                    ani[nx][ny] = true;
                    leastRoad[nx][ny] = leastRoad[poll1.x][poll1.y] + 1;        // 그리고 최소 거리 갱신해줌
                }
            }

            }
        System.out.println("KAKTUS");                           // animal 큐 다 빌때까지 뭐가 없으면 KAKTUS
        return;
        }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

/**
 * 아니 메모리초과가 너무 나서 뭔가 대체 싶었는데
 * 핵심은 고슴도치가 지나온 자리 또한 방문처리를 해야한다는 것이였다.
 * 이거 ani[][] 처리 해줬더니 귀신같이 맞음
 */
