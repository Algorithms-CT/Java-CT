package Part2.BOJ2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2164_99hyeon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        br.close();

        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }

        int count = 1;
        while(queue.size() > 1){
            if(count % 2 != 0){   //홀수일경우
                queue.remove();
                count++;
            }else{
                queue.offer(queue.element());
                queue.remove();
                count++;
            }
        }
        System.out.println(queue.element());
    }
}

/**
 * 한번은 원소를 제거하고 한번은 원소를 제일 뒤로 보내는걸 원소가 1개 남았을 때 까지 반복한다.
 * 자바에서 제공하는 함수를 사용해서 해결하였다.
 * 반복하는 것은 count를 통해서 count가 홀수면 원소를 제거하고
 * count가 짝수면 원소를 제일 뒤로 보내는 방식으로 하였다.
 */
