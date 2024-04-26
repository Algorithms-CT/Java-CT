package Part2.BOJ1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B1655_99hyeon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        int num = Integer.parseInt(br.readLine());


        for(int i = 1; i <= num; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(i % 2 == 1){ //홀수번째
                maxQueue.add(tmp);
            }else{
                minQueue.add(tmp);
            }

            if(!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peek() > minQueue.peek()){
                int max = maxQueue.poll();
                int min = minQueue.poll();
                maxQueue.add(min);
                minQueue.add(max);
            }
            sb.append(maxQueue.peek()).append("\n");
        }
        br.close();

        System.out.println(sb);
    }
}

/**
 * 오름차순 힙인 maxQueue와 내림차순 힙인 minQueue를 사용해서 중간값을 구한다.
 * 우선 입력값을 차례대로 maxQueue와 minQueue에 번갈아 가면 삽입해준다.
 * 삽입하면서 두 힙의 루트 노드를 비교해 maxQueue의 루트노드가 더 크면
 * 두 루트노드를 swap해준다.
 * 그러면 maxQueue의 루트노드가 이때까지 입력값의 중앙값을 가지고 있다.
 */