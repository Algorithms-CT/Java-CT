package Part2.BOJ11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B11279_99hyeon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp == 0){
                if(!priorityQueue.isEmpty()){   //배열이 비어있지 않다면 제일 큰 수 출력
                    sb.append(priorityQueue.poll()).append("\n");
                }else{  //배열이 비었다면 0 출력
                    sb.append("0").append("\n");
                }
            }else{
                priorityQueue.add(tmp);
            }
        }
        br.close();

        System.out.println(sb);
    }
}
/**
 * 큰 기술 없이
 * 제공되는 함수를 잘 사용하면 된다.
 */
