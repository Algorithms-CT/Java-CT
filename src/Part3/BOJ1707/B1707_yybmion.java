package Part3.BOJ1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B1707_yybmion {
    static int[] team;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer stt;

        while(N-->0){

            stt = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(stt.nextToken());
            int E = Integer.parseInt(stt.nextToken());

            graph = new ArrayList<>();
            team = new int[V+1];

            for(int i=0;i<=V;i++){
                graph.add(new ArrayList<>());
            }

            for(int j=0;j<E;j++) {
                stt = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(stt.nextToken());
                int v2 = Integer.parseInt(stt.nextToken());

                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }

            boolean res = false;

            for(int i=0;i<=V;i++){
                if(team[i]==0){
                    res = isBipart(i);
                }
                if(!res) break;
            }
            if(res) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean isBipart(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        team[i] = 1;

        while(!queue.isEmpty()){
            Integer cur = queue.poll();
            for (Integer next : graph.get(cur)) {
                if(team[cur] == team[next]) return false;

                if(team[next]==0){
                    team[next] = team[cur]*-1;
                    queue.add(next);
                }
            }
        }
        return true;
    }
}
