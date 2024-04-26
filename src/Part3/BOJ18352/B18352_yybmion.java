package Part3.BOJ18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B18352_yybmion {
    static int N;
    static int M;
    static int K;
    static int X;
    static Queue<Integer> queue;        // 그래프 노드 하나씩 넣을거임
    static boolean[] visited;
    static int[] leastRoad;             // 최단거리 저장 배열
    static List<Integer> ans;           // 최단거리랑 구하려는 최단거 값이랑 같을때 저장
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stt = new StringTokenizer(br.readLine());
        graph = new ArrayList<>();

        N = Integer.parseInt(stt.nextToken());
        M = Integer.parseInt(stt.nextToken());
        K = Integer.parseInt(stt.nextToken());
        X = Integer.parseInt(stt.nextToken());

        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            stt = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(stt.nextToken());
            int e2 = Integer.parseInt(stt.nextToken());
            graph.get(e1).add(e2);      // 단방향 저장
        }

        queue = new LinkedList<>();
        visited = new boolean[N+1];
        leastRoad = new int[N+1];
        ans = new ArrayList<>();

        queue.add(X);
        visited[X] = true;
        leastRoad[X] = 0;
        bfs();
    }

    static void bfs(){

        while(!queue.isEmpty()){
            int node = queue.poll();            // 처음 출발 노드 꺼내서
            for (int value : graph.get(node)) {     // 그 인접한 노드 값 뽑아서
                if(!visited[value]){                // 방문한적이 없다면
                    visited[value] = true;              // 방문체크 후
                    leastRoad[value] = leastRoad[node]+1;       // 거리를 +1 해준다.
                    if(leastRoad[value] == K) ans.add(value);   // 만약 그 거리가 구하려는 최단거리랑 같다면 ans 리스트에 넣어줌
                    queue.add(value);                           // 인접했던 노드도 큐에 넣어준다.
                }

            }
        }
        if(ans.size()==0){                  // 답 없으면 -1 출력
            System.out.println(-1);
        }else {
            Collections.sort(ans);          // 답 여러개면 오름차순 정렬 후 출력
            for (Integer ret : ans) {
                System.out.println(ret);
            }
        }
    }
}
