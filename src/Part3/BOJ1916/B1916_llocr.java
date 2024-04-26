package Part3.BOJ1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1916_llocr {
    public static class Bus implements Comparable<Bus>{
        int end;
        int cost;

        public Bus(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return this.cost - o.cost;
        }
    }

    static ArrayList<Bus>[] arr;
    static boolean[] visited;
    static int startPoint;
    static int endPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i<n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a].add(new Bus(b,c));
        }
        st = new StringTokenizer(br.readLine());
        startPoint = Integer.parseInt(st.nextToken());
        endPoint = Integer.parseInt(st.nextToken());

        System.out.println(BFS(startPoint));
    }

    private static int BFS(int startPoint) {
        PriorityQueue<Bus> queue = new PriorityQueue<>();

        queue.add(new Bus(startPoint, 0));
        visited[startPoint] = true;

        while(!queue.isEmpty()) {
            Bus now = queue.poll();

            if(now.end == endPoint) return now.cost;
            visited[now.end] = true;

            for(Bus bus : arr[now.end]) {
                if(!visited[bus.end]) {
                    queue.add(new Bus(bus.end, now.cost + bus.cost));
                }
            }
        }
        return -1;
    }
}

/*
우선순위큐 안 쓰고, Comparable 구현 안 하고 그냥 모든 노드를 다 돌다가
답은 맞는데, 시간 초과가 뜨는 걸 경험했다 :(
0.5초는 역시 어렵구나 여러워,,,
인터넷에서 다익스트라 알고리즘을 검색한 후에 문제풀이를 다시 진행했다..!!
 */

