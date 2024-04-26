package Part3.BOJ21606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B21606_llocr {
    static int n;
    static int[] check;
    static ArrayList<Integer>[] tree;

    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        check = new int[n+1];
        visited = new boolean[n+1];
        tree = new ArrayList[n+1];

        String s = br.readLine();

        for(int i = 0; i<n; i++) {
            check[i + 1] = Integer.parseInt(String.valueOf(s.charAt(i)));
            tree[i+1] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);

            if(check[a] == 1 && check[b] == 1) { //실내끼리 인접했을 경우 경로를 2개 더해 준다.
                answer += 2;
            }

        }

        for(int i = 1; i<=n; i++) {
            int in = 0;
            if(check[i] == 0)  {
                if(!visited[i]) {
                    visited[i] = true;
                    in = DFS(i);
                }
            }
            answer += in*(in-1);
        }

        System.out.println(answer);
    }

    public static int DFS(int start) {
        int in = 0;

        for(int i : tree[start]) {
            if(check[i] == 0) {
                if(!visited[i]) {
                    visited[i] = true;
                    in += DFS(i);
                }
            } else {
                in++;
            }
        }

        return in;
    }
}

/*
* 참고 : https://velog.io/@kimgunwooo/%EB%B0%B1%EC%A4%80-21606%EB%B2%88-%EC%95%84%EC%B9%A8-%EC%82%B0%EC%B1%85
*
* 블로그랑 똑같이 생각했다,, 처음에는 실내에서 시작하는 노드를 찾고, 거기서부터 DFS를 돌려주면 되겠다!
* 200점 만점 중에 100점도 못 되는 점수를 받았다..^^
* 시간 초과와 내 코드에 작은 문제가 있었던 것 같다,,
*
* 실내 - 실내의 수를 세야겠다는 생각을 버리고 실외를 기준으로 찾아야 한다는 것이 이 문제의 포인트였던 것 같다
* 더 많은 문제를 풀어볼 필요가 있다! :(
* */