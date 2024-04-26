package Part4.BOJ2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2098_llocr {
    static int n;
    static final int INF = 16_000_000;
    static int[][] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][(1<<n)-1];

        for(int i = 0 ; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 1));

    }

    static int dfs(int now, int visit) {
        //모든 도시를 지난 경우
        if(visit == (1<<n)-1) {
            //now -> 0(출발도시)로 가는 경로가 존재해야 돌아갈 수 있음
            if(arr[now][0] == 0) return INF;
            return arr[now][0];
        }

        if(dp[now][visit] != -1) return dp[now][visit];
        dp[now][visit] = INF;

        for(int i=0; i<n; i++) {
            //now -> 아직 방문하지 않는 i번 도시 가는 경로가 있는 경우
            if((visit & (1<<i)) == 0 && arr[now][i] != 0) {
                //dp[i][j] = 현재 있는 도시가 i이고 이미 방문한 도시들의 집합이 j일 때,
                //방문하지 않은 나머지 도시들을 모두 방문한 뒤 출발 도시로 돌아올 때 드는 최소 비용,
                //즉, 방문해야하는 도시(여기에 시작지점으로 돌아오는것 포함) 들까지 가는 최소 비용
                dp[now][visit] = Math.min(dfs(i, visit | (1<<i)) + arr[now][i], dp[now][visit]); //최소비용 갱신
                // dfs(다음 도시, 다음도시 방문했다고 가정) + 여기서 다음 도시까지의 거리 와 최소거리 비교
            }
        }

        return dp[now][visit];
    }
}

/*
* TSP 알고리즘
* 참고 :
* https://withhamit.tistory.com/246
* https://velog.io/@zeesouth/%EB%B0%B1%EC%A4%80-2098.-%EC%99%B8%ED%8C%90%EC%9B%90-%EC%88%9C%ED%9A%8C-Java
*
* 비트마스트
* 참고 :
* https://gyoogle.dev/blog/algorithm/BitMask.html
* https://rebro.kr/63
*
* 그냥 눈물ㅇㅣ 줄줄 나오면서 정신이 혼미해지는 문제...
* 일단 따라 적어두긴 했는데 더 깊이 이해하고 다시 풀어봐야 할 것 같다...
* 이 문제 나한테 너무 맵다...
* */
