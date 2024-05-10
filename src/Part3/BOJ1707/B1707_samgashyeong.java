import java.io.*;
import java.util.*;

//문제 자체를 이해하느라 애를 먹었던 문제. 문제를 이해해도 결국에 68%에서 '틀렸습니다.'가 떠서 자존심을 버리고 정답 로직을 참고한 문제
public class B1707_samgashyeong {
    static ArrayList<Integer>[] arr = new ArrayList[20002];
    static int[] colorArr = new int[20002];

    //탐색을 하면서 방문한 노드가 현재 노드랑 같을 때 false를 리턴해줌.
    static boolean dfs(int cur, int color) {
        colorArr[cur] = color;
        for (int next : arr[cur]) {
            if (colorArr[next] == 0) {
                if (!dfs(next, -color)) return false;
            } else if (colorArr[next] == colorArr[cur]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= v; i++) {
                arr[i] = new ArrayList<>();
                colorArr[i] = 0; 
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                arr[from].add(to);
                arr[to].add(from);
            }

            boolean isBipartite = true;
            for (int i = 1; i <= v; i++) {
                if (colorArr[i] == 0) {
                    if (!dfs(i, 1)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }
}