package Part3.BOJ1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1197_99hyeon {

    public static int find(int x, int[] parent){
        if(parent[x] == x){
            return x;
        }else{
            return find(parent[x], parent);
        }
    }

    public static void union(int x, int y, int[] parent){
        x = find(x, parent);
        y = find(y, parent);

        if(x < y){
            parent[y] = x;
        }else{
            parent[x]= y;
        }
    }

    public static void kruscal(int[][] graph, int[] parent){
        int cost = 0;

        for(int i = 0; i < graph.length; i++){
            if(find(graph[i][0], parent) != find(graph[i][1],parent)){
                union(graph[i][0], graph[i][1], parent);
                cost += graph[i][2];
            }
        }

        System.out.println(cost);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] graph = new int[E][3];
        int[] parent = new int[V + 1];

        for(int i = 1; i < V+1; i++){
            parent[i] = i;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph, (o1, o2) -> {return o1[2] - o2[2];});

        kruscal(graph, parent);
    }
}

/**
 * 위는 크루스칼 알고리즘을 사용하여 MST의 가중치 합을 구하였다.
 * 전형적인 크루스칼 알고리즘을 사용하였다.
 */
