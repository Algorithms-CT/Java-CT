package Part3.BOJ2637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2637_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] arr = new ArrayList[n+1];
        for(int i = 0; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] indegree = new int[n+1];
        int[] count = new int[n+1];

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr[x].add(new int[] {y, k});   //필요한 부품 저장

            indegree[y]++;                  //y가 총 필요한 횟수 저장
            count[x]++;                     //x를 만들 때 필요한 부품 갯수 저장
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[n+1];        //총 몇 번 필요할까요!?

        queue.add(n);                       //원래는 indegree가 0인 것을 찾아서 add 해주어야 하지만
        answer[n] = 1;                      //indegree가 0인 것은 최종 제품밖에 없으므로 for문 돌지 않고 바로 삽입

        while(!queue.isEmpty()) {
            int now = queue.poll();         //현재 부품 꺼내기

            for(int[] toy : arr[now]) {     //부품을 만들기 위한 하위 부품들 꺼내기
                int y = toy[0];
                int k = toy[1];

                if(--indegree[y] == 0) {    //하위 부품의 필요 횟수 --, indegree 0이 되면 queue에 삽입
                    queue.add(y);
                }

                answer[y] += k * answer[now];// 전체 y가 필요한 갯수 += (now를 만들기 위해 필요한 갯수) * (현재 now의 갯수)
            }
        }

        for(int i = 1; i<=n; i++) {
            if(count[i] == 0) {             //가장 기본 부품일 때
                sb.append(i).append(" ").append(answer[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
