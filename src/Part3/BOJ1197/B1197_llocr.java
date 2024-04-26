package Part3.BOJ1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1197_llocr {
    static int v;
    static int e;

    static int[] parent;
    static int[] rank;

    static PriorityQueue<Edge> edges;

    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return;

        if(rank[a] < rank[b]) {
            parent[a] = b;
        } else {
            parent[b] = a;

            if(rank[a] == rank[b]) rank[a]++;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge (int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        rank = new int[v + 1];
        edges = new PriorityQueue<>();

        for(int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, weight));
        }

        int sum = 0;

        while(!edges.isEmpty()) {
            Edge edge = edges.poll();

            if(find(edge.from) == find(edge.to)) {
                continue;
            }

            union(edge.from, edge.to);
            sum += edge.weight;
        }

        System.out.println(sum);
    }
}

/*
* 참고 : https://velog.io/@doxxx93/boj-1197
*
* - 크루스칼 알고리즘을 사용한 풀이
* 크루스칼 알고리즘은 주어진 그래프의 모든 Edge들의 가중치를 오름차순으로 정렬한다.
* 이후, 사이클을 형성하지 않는 선에서 지금까지 만든 MST에 Edge를 하나씩 하나씩 추가한다.
* 모든 Edge들을 탐색하며 greedy하게 선택하며, Edge가 전체 노드의 개수 - 1개가 될 때 까지 Edge를 추가하는 과정을 반복한다.
* 크루스칼 알고리즘을 따르게 되면, 단 1개의 MST를 가지게 된다.
* 보통 E를 Edge의 개수, V를 Node의 개수라고 하게 되면, 시간 복잡도는 O(ElogV)안에 동작한다고 증명된다.
* E는 최대 V^2개일 수 있기 때문에, log 연산을 하게 될 경우, logE == logV^2 == 2logV임을 이용한다.
* 이에 필요한 자료구조는 서로소 집합(disjoint-set)이고, 이러한 서로소 집합을 서로 합치는 union과정과 어떤 Node가 어떤 서로소 집합에 속하는지 탐색하는 find과정을 이용하여 구한다.
* 흔하게 알려진 union-find 알고리즘이다.
*
* union-find 개념을 더 학습하고, 관련 문제를 좀 더 풀어봐야겠다는 생각..!!
* */
