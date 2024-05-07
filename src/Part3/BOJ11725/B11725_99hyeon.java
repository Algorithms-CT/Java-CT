package Part3.BOJ11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11725_99hyeon {

    static int[] parent;
    static Boolean[] check;
    static ArrayList<Integer>[] nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(st.nextToken());
        parent = new int[num+1];
        check = new Boolean[num + 1];
        nodeList = new ArrayList[num+1];

        Arrays.fill(parent, 0);
        Arrays.fill(check, false);

        for(int i = 0; i <= num; i++){
            nodeList[i] = new ArrayList<>();
        }

        for(int i = 0; i < num-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodeList[x].add(y);
            nodeList[y].add(x);
        }
        br.close();

        //탐색
        DFS(1);

        //출력
        for(int i = 2; i <= num; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int index){
        check[index] = true;    //탐색하면서 방문했다고 표시
        for(int i : nodeList[index]){
            if(!check[i]){  //방문하지 않았으면 해당 index가 부모 노드이므로
                parent[i] = index;  //해당 인덱스의 배열에 부모노드 숫자 넣기
                DFS(i); //해당 노드의 자식 노드 있는지 확인
            }
        }
    }
}

/**
 * 참고 : https://codesign.tistory.com/122
 */
