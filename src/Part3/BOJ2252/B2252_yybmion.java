package Part3.BOJ2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2252_yybmion {
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] edgeCount;                     // 선후관계 표현할 count
    static Queue<Integer> queue;
    static int[] seq;                           // 줄 세우기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stt.nextToken());
        M = Integer.parseInt(stt.nextToken());
        edgeCount = new int[N+1];
        queue = new LinkedList<>();
        seq = new int[N];
        graph = new ArrayList<>();

        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            stt = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(stt.nextToken());
            int e2 = Integer.parseInt(stt.nextToken());

            graph.get(e1).add(e2);
            edgeCount[e2] += 1;         // 간선 연결 후 선후관계 count 해줌 선후관계란 : https://codingnojam.tistory.com/66
        }

        for(int i=1;i<edgeCount.length;i++){
            if(edgeCount[i]==0){            // 선후관계 count가 0이면 바로 큐에 넣음
                queue.add(i);
            }
        }
        bfs();

        for (int res : seq) {               // 줄 세우기 출력
            System.out.print(res + " ");
        }
    }

    static void bfs(){
        int j=0;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            seq[j++] = poll;            // 큐에서 나오는 순서대로 줄세우기

            for(int ret : graph.get(poll)){         // 그 큐의 값과 연결된 노드들을 확인해서 -1씩 해준다.
                edgeCount[ret] -= 1;                // 이후 그 노드의 선후관계 count또한 0이 된다면 queue에 넣어준다.
                if(edgeCount[ret]==0) queue.add(ret);       // 큐 빌때까지 반복
            }                                                   // 이러면 순서가 생김 신기하게
        }
    }
}
