package Part3.BOJ1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_99hyeon {

    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static int node, line, start;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start= Integer.parseInt(st.nextToken());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for(int i = 0 ; i < line ; i ++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }
        br.close();

        //sb.append("\n");
        dfs(start);
        sb.append("\n");

        //check 배열 false로 초기화
        Arrays.fill(check, false);
        bfs(start);

        System.out.println(sb);
    }

    public static void dfs(int start) {

        check[start] = true;
        sb.append(start).append(" ");

        for(int i = 0 ; i <= node ; i++) {
            if(arr[start][i] == 1 && !check[i])
                dfs(i);
        }
    }

    public static void bfs(int start) {
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {

            start = q.poll();
            sb.append(start).append(" ");

            for(int i = 1 ; i <= node ; i++) {
                if(arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}

/**
 * 코드가 워낙 간단해서 설명은 생략하겠다.
 */
