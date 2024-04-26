package Part3.BOJ1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1916_yybmion {
    static class Node implements Comparable<Node>{
        int to;
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }
    }

    static int start;
    static int end;
    static ArrayList<ArrayList<Node>> tree;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();

        StringTokenizer stt;

        for(int i=0;i<=N;i++){
            tree.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            stt = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(stt.nextToken());
            int e2 = Integer.parseInt(stt.nextToken());
            int value = Integer.parseInt(stt.nextToken());
            tree.get(e1).add(new Node(e2,value));
        }

        stt = new StringTokenizer(br.readLine());

        start = Integer.parseInt(stt.nextToken());
        end = Integer.parseInt(stt.nextToken());

        int ans = search();

        System.out.println(ans);

    }

    static int search(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.to == end){
              return cur.value;
            }
            visited[cur.to] = true;

            for(Node next : tree.get(cur.to)){
                if(!visited[next.to]){
                    pq.add(new Node(next.to,cur.value + next.value));
                }
            }
        }
        return -1;

    }

//    static int N;
//    static int M;
//    static ArrayList<ArrayList<Node>> tree;
//    static PriorityQueue<Node> queue;
//    static boolean[] visited;
//    static int start;
//    static int end;
//    static int[] leastRoad;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stt;
//        Arrays.fill(leastRoad,(int)1e9);
//
//        N = Integer.parseInt(br.readLine());
//        M = Integer.parseInt(br.readLine());
//
//        tree = new ArrayList<>();
//        queue = new PriorityQueue<>();
//        visited = new boolean[N+1];
//        leastRoad = new int[N+1];
//
//        for(int i=0;i<N+1;i++){
//            tree.add(new ArrayList<>());
//        }
//
//        for(int i=0;i<M;i++){
//            stt = new StringTokenizer(br.readLine());
//            int e1 = Integer.parseInt(stt.nextToken());
//            int e2 = Integer.parseInt(stt.nextToken());
//            int cost = Integer.parseInt(stt.nextToken());
//            Node node = new Node(e2,cost);
//
//            tree.get(e1).add(node);
//
//        }
//
//        stt = new StringTokenizer(br.readLine());
//
//        start = Integer.parseInt(stt.nextToken());
//        end = Integer.parseInt(stt.nextToken());
//
//        queue.add(new Node(start,0));
//        visited[start] = true;
//        leastRoad[start] = 0;
//        bfs();
//
//    }
//
//    static void bfs(){
//
//        while(!(queue.isEmpty())){
//
//            Node poll = queue.poll();
//
//            int endPoint = poll.to;
//
//            if(leastRoad[endPoint]<poll.cost) continue;
//
//            for (Node ret : tree.get(endPoint)) {
//
//
//                if(visited[ret.to] && leastRoad[ret.to]<leastRoad[poll] + ret.cost){
//                    continue;
//                }else if(visited[ret.to] && leastRoad[poll] + ret.cost < leastRoad[ret.to]){
//                    leastRoad[ret.to] = leastRoad[poll] + ret.cost;
//                    queue.add(ret.to);
//                }
//
//                if(visited[ret.to] == false){
//                    visited[ret.to] = true;
//                    queue.add(ret.to);
//                    leastRoad[ret.to] = leastRoad[poll] + ret.cost;
//                }
//
//            }
//        }
//
//        System.out.println(leastRoad[end]);
//    }
//
//    static class Node{
//
//        int to;
//        int cost;
//
//        public Node(int to, int cost) {
//            this.to = to;
//            this.cost = cost;
//        }
//    }

}

/**
 * https://tussle.tistory.com/998
 */
