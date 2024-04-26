package Part3.BOJ18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18352_llocr {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        depth = new int[n+1];
        arr = new ArrayList[n+1];

        for(int i = 1; i<n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
        }

        BFS(x);

        for(int i = 1; i<depth.length; i++) {
            if(depth[i] == k) { //거리가 k인지 확인하고, 맞으면 출력
                sb.append(i).append("\n");
            }
        }

        if(sb.length() == 0) sb.append(-1).append("\n");
        // sb.isEmpty() 메서드를 썼다가 java 11에는 없는 건지 빠꾸 먹었다.. 그래서 length로 비교하는 걸로 변경
        System.out.println(sb);
    }

    private static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int i : arr[now]) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    depth[i] = depth[now] + 1; //거리 기록
                }
            }
        }
    }
}
