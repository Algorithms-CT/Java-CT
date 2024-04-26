package Part3.BOJ2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2252_llocr {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        for(int i = 0; i<n+1; i++) {
            arr.add(new ArrayList<>()); //인접리스트 초기화
        }

        int[] indegree = new int[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            indegree[b]++; //진입차수 배열 데이터 저장 부분
        }

        //위상정렬
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            
            for(int next : arr.get(now)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
