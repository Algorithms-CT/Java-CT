package Part4.BOJ1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1931_yybmion {
    static ArrayList<Node> list;
    static ArrayList<Node> let;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stt;
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        let = new ArrayList<>();
        int j = 0;

        for(int i=0;i<N;i++){
            stt = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stt.nextToken());
            int ed = Integer.parseInt(stt.nextToken());

            list.add(new Node(st,ed));
        }

        Collections.sort(list);   // 정렬을 하는데 어떤 기준으로 정렬할거야?? comparable로 만져주자

        let.add(list.get(0));     // 정렬하면 무조건 첫번쨰 값은 먼저 들어갈 수 있음

        for(int i=1;i<N;i++){
            if(let.get(j).end<=list.get(i).start){  // 정렬한 후니까 첫번쨰 들어간 값의 회의 끝나는 시각보다 새로 시작해야할 회의 시작시간이 크거나 같으면 들어갈 수 있음
                let.add(list.get(i));       // 그래서 넣어줌
                j++;
            }
        }

        System.out.println(let.size());     // 사이즈 잼
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {          // 여기가 중요한데 종료시간 즉, end를 기준으로 정렬해야하는데 start도 end를 중점으로 정렬이 되어야한다는 것
            if(this.end == o.end){              // 즉 (3,3) , (2,3) , (1,3) , (2,2) 가 오면 (2,2) , (1,3) , (2,3) , (3,3) 으로 정렬될거임
                return this.start - o.start;
            }else{
                return this.end - o.end;
            }
        }
    }
}

/**
 * 일단 해당 문제에서 기본적으로 정렬이 되어있는 줄 알고 정렬을 하지 않고 종료시간을 기준으로 계산을 하였다.
 * 하지만 정렬은 되어있지 않고 내가 해줘야하는데, 몇가지 유의해야할 사항이 있다.
 * 첫번째는 아까 말한 정렬을 했는지의 문제이다.
 *
 * 1. 정렬을 했는지
 *
 * - 이 문제는 입력이 반드시 오름차순으로 주어지지 않습니다.
 *
 * 4
 * 3 3
 * 2 3
 * 1 3
 * 2 2
 *
 * 2. 정렬을 제대로 했는지
 *
 * - 이 문제는 종료시간만 기준이 되면 안됩니다. 시작시간도 정렬의 기준에 포함되어야 합니다.
 *
 * 4
 * 3 3
 * 2 3
 * 1 3
 * 2 2
 *
 * 3. 시작하자마자 끝나는 회의를 잘 고려했는지
 *
 * - 얘네들은 여러개 나와도 다 카운트 해 주어야 합니다.
 *
 * input
 *
 * 4
 * 1 4
 * 4 4
 * 4 4
 * 4 5
 */
